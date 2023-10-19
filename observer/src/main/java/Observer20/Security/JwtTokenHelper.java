package Observer20.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import Observer20.Model.AC_LIST2;
import Observer20.Model.Obs_Allot;
import Observer20.Model.ObserverUser;
import Observer20.repository.AC_LIST2_REPO2;
import Observer20.repository.Obs_AllotREPO;
import Observer20.repository.ObserverUserRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenHelper {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60; // 5 hours
    private String secret = "JwtTokenKey"; // Replace this with your secret key

    @Autowired
    private ObserverUserRepo observerUserRepo;
    @Autowired
    Obs_AllotREPO obs_AllotREPO; 
    @Autowired
    AC_LIST2_REPO2 aC_LIST2_REPO2;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        ObserverUser observerUser = observerUserRepo.findByObscode(userDetails.getUsername());

        List<Obs_Allot> obsAllotList = obs_AllotREPO.findAllByObscode(observerUser.getObscode());
        if (obsAllotList == null || obsAllotList.isEmpty()) {
            throw new RuntimeException("Obs_allot entries not found for obscode: " + observerUser.getObscode());
        }

        List<String> acNamesList = new ArrayList<>();
        for (Obs_Allot obsAllot : obsAllotList) {
            String stCode = obsAllot.getSt_Code();
            String acNo = obsAllot.getAc_No();
            String obsCode = obsAllot.getObscode();
            List<AC_LIST2> acList = aC_LIST2_REPO2.findAllByStCodeAndAcNo(stCode, acNo);

            StringBuilder acNames = new StringBuilder();
            if (acList != null && !acList.isEmpty()) {
                for (AC_LIST2 ac : acList) {
                    acNames.append(ac.getAcNameEn()).append(", ");
                }

                if (acNames.length() > 0) {
                    acNames.setLength(acNames.length() - 2);
                } else {
                    acNames.append("AC Name Not Found");
                }
            } else {
                acNames.append("AC Name Not Found");
            }

            acNamesList.add(acNames.toString());
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("obscode", observerUser.getObscode());
        claims.put("profileStatus", observerUser.getProfileStatus());
        claims.put("constituencies", acNamesList);

        return doGenerateToken(claims, userDetails.getUsername());
    }


    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)) // in milliseconds
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    
    
}