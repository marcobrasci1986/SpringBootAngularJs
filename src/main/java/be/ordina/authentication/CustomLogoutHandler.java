package be.ordina.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by MaBa on 29/03/16.
 */
@Service
public class CustomLogoutHandler implements LogoutHandler {

    /**
     * Add custom logic here to execute after the logout is preformed
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println("Do stuff after logging out: " + SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
