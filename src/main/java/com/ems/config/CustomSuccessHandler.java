package com.ems.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        for (GrantedAuthority auth : authorities) {
            String role = auth.getAuthority();
            if (role.equals("ROLE_ADMIN")) {
                response.sendRedirect(request.getContextPath() + "/admin");
                return;
            } else if (role.equals("ROLE_EMPLOYEE")) {
                response.sendRedirect(request.getContextPath() + "/employee");
                return;
            } else if (role.equals("ROLE_CLIENT")) {
                response.sendRedirect(request.getContextPath() + "/client");
                return;
            }
        }

        response.sendRedirect(request.getContextPath() + "/login?error=true");
	}

}
