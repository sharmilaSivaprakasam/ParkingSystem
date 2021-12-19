package com.webapp.parkingsystem;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.webapp.parkingsystem.repository.UserRepository;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> userRepository.getByUsername(username)
//              .orElseThrow(() -> new UsernameNotFoundException(format("User: %s, not found", username))));
//    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().antMatchers("/**").permitAll().and().formLogin();
    }
}
