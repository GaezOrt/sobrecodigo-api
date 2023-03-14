package com.example.medial.security;

import com.example.medial.security.business.MyUserDetailsService;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Basic;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.userDetailsService(myUserDetailsService);
        httpSecurity.authorizeRequests().antMatchers("/1.0/users/log-in").permitAll()
                .antMatchers("/1.0/users/prueba").permitAll()
                .antMatchers("/1.0/users/register-first-step").permitAll()
                .antMatchers("/1.0/documents/").permitAll()
                .antMatchers("/1.0/paises/").permitAll()
                .antMatchers("/1.0/users/change-password/request").permitAll()
                .antMatchers("/1.0/users/change-password/send-code").permitAll()
                .antMatchers("/1.0/rubros/").permitAll()
                .antMatchers("/1.0/requests/pendientes").permitAll()
                .antMatchers("/1.0/users/writeBlobFile").permitAll().
                antMatchers("/1.0/versionado/check").permitAll().
                antMatchers("/1.0/requests/create-request").permitAll().
                antMatchers("/1.0/projects/recent-projects").permitAll().
                antMatchers("/1.0/jobs/recent-jobs").permitAll().
                antMatchers("/1.0/projects/by-user").permitAll().
                antMatchers("/1.0/users/info").permitAll().

                anyRequest().authenticated();
        httpSecurity.exceptionHandling().accessDeniedPage("/1.0/users/log-in");
        httpSecurity.csrf().disable();

        httpSecurity.apply(new JwtTokenFilterConfigurer(jwtUtil));


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
