package com.login.app.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals("USER")) {
                httpServletResponse.sendRedirect("/login-app/welcome");
                return;
            } else if (grantedAuthority.getAuthority().equals("ADMIN")) {
                httpServletResponse.sendRedirect("/login-app/admin-panel");
                return;
            }
        }
    }
}
