package com.example.medial.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JWTUtil jwtUtil;

    public JwtTokenFilterConfigurer( JWTUtil jwtUtil) {
        this.jwtUtil= jwtUtil;
    }

    @Override
    public void configure(HttpSecurity httpSecurity){
        JwtTokenFilter customFilter= new JwtTokenFilter(jwtUtil);
        httpSecurity.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
