package com.stussy.stussyclone20220930dohyun.api.advice;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFailureHandler implements AuthenticationFailureHandler {
    //이 클래스가 UserNameNotFoundException을 잡음, AuthenticationException으로 업캐스팅 돼서 넘어옴
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if(exception.getClass() == UsernameNotFoundException.class || exception.getClass() == BadCredentialsException.class) {
            response.sendRedirect("/account/login?error=auth");
        } else if(exception.getClass() == CredentialsExpiredException.class) {
            response.sendRedirect("/account/login?error=passwordExpired");
        } else {
            response.sendRedirect("/account/login?error");
        }
    }
}
