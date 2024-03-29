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
                .antMatchers("/1.0/users/active").permitAll()
                .antMatchers("/1.0/users/most-active").permitAll()
                .antMatchers("/1.0/technologies/").permitAll()
                .antMatchers("/1.0/technologies/icons/by-technology/*").permitAll()
                .antMatchers("/1.0/technologies/by-user").permitAll()
                .antMatchers("/1.0/technologies/by-user/*").permitAll()
                .antMatchers("/1.0/icons/by-user/*").permitAll()
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
                antMatchers("/1.0/projects/recent").permitAll().
                antMatchers("/1.0/projects/by-id/*").permitAll().

                antMatchers("/1.0/jobs/recent").permitAll().
                antMatchers("/1.0/jobs/new").permitAll().
                antMatchers("/1.0/jobs/new").permitAll().
                antMatchers("/1.0/projects/by-user").permitAll().
                antMatchers("/1.0/users/info").permitAll().
                antMatchers("/1.0/users/info-by-id/*").permitAll().


                //para poder ver todos los endpoints navegando a "localhost:8080/swagger-ui/index.html"
                        antMatchers("/swagger-ui.html").permitAll().
                antMatchers("/swagger-ui/**").permitAll().
                antMatchers("/v3/api-docs/**").permitAll().

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
