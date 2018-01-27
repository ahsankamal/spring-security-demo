package com.codeIntrigue.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        UserBuilder users =  User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("ahsan").password("test123").roles("admin"))
                .withUser(users.username("kamal").password("test456").roles("user"))
                .withUser(users.username("ihsan").password("test789").roles("manager"));

    }
}
