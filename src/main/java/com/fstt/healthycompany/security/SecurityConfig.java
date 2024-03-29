package com.fstt.healthycompany.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/testpsies/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/questions/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/reponses/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/testResponseses").permitAll();

        http.authorizeRequests().antMatchers("/testpsies/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/questions/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/reponses/**").hasAnyAuthority("ADMIN");

        http.authorizeRequests().antMatchers("/testResponseses/**").hasAnyAuthority("USER");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }


}
