package com.Security21.SpringSecurity.JWT.Security.FIlter;

import com.Security21.SpringSecurity.JWT.Service.UserDetailsServiceImpl;
import com.Security21.SpringSecurity.JWT.Security.jwt.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class jwtAuthorizationFIlter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,@NotNull HttpServletResponse response,@NotNull FilterChain filterChain) throws ServletException, IOException {
           String tokenHeader= request.getHeader("Authorization");

           if(tokenHeader != null && tokenHeader.startsWith("Bearer ") ){

               String token= tokenHeader.substring(7);

               if(jwtUtils.isTokenValid(token)){
                   String username= jwtUtils.getUsernamefromToken(token);
                   UserDetails userDetails= userDetailsService.loadUserByUsername(username);

                   UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(username , null , userDetails.getAuthorities());

                   SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

               }
           }

           filterChain.doFilter(request,response);

    }
}
