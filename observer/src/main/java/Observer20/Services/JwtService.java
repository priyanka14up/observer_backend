package Observer20.Services;

import org.springframework.stereotype.Service;

import Observer20.Exception.HandledException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
@Service
public class JwtService {

    private String secretKey = "JwtTokenKey";

    public Claims decodeJWT(String jwtToken) throws HandledException {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwtToken)
                    .getBody();
        } catch (Exception e) {
            
            throw new HandledException("Invalid token", e.getMessage());
        }
    }
}