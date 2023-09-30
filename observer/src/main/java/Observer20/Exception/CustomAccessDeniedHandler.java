package Observer20.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(javax.servlet.http.HttpServletRequest request,
                       javax.servlet.http.HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws java.io.IOException, javax.servlet.ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().write("Access Denied: You don't have permission to access this resource.");
        response.getWriter().flush();
    }
}
