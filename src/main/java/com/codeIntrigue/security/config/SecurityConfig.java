package com.codeIntrigue.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    //used by spring security filters


    //configure user (in-memory, db etc)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        UserBuilder users =  User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("ahsan").password("test123").roles("admin"))
                .withUser(users.username("kamal").password("test456").roles("user"))
                .withUser(users.username("ihsan").password("test789").roles("manager"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //spring provides default login page

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/customLoginPage")//controller req for req mapping
                .loginProcessingUrl("/authenticateUserCredentials")//no controller  req (spring filter will handle it)
                .permitAll()//any one can see login page
                .and()
                .logout().permitAll();
    }
}
