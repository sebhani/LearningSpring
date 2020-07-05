package com.example.springSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //tells Spring Security that this security is web-based and not application/method security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //set your configuration on the auth object
        //1- specify what type of authentication you want to implement
        auth.inMemoryAuthentication()
                .withUser("hani")
                .password("123456")
                .roles("USER")
                .and()
                .withUser("khaled")
                .password("000000")
                .roles("ADMIN");
    }

    //2- provide an encoder
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
