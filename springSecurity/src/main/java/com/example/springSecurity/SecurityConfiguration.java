package com.example.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity //tells Spring Security that this security is web-based and not application/method security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /*
    // In memory authentication

    // Authentication configuration
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


    // Authorization configuration
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //You specify accessibility from the most to the least restrictive
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
    */

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    //our embedded database --> H2
    @Autowired
    DataSource dataSource;


     * JDBC authentication

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource) //specify the database location
        .usersByUsernameQuery("select username, password, enabled " +
                "from users " +
                "where username = ?") //specify customized tables for users and authorities
        .authoritiesByUsernameQuery("select username, authority " +
                "from authorities " +
                "where username = ?");
            //.withDefaultSchema() // uses the default schema
            //.withUser(
            //        User.withUsername("user")
            //        .password("pass")
            //        .roles("USER")
            //)
            //   .withUser(
            //            User.withUsername("admin")
            //            .password("pass")
            //            .roles("ADMIN")
            //    );

    }

    //2- provide an encoder
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    // Authorization configuration
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //You specify accessibility from the most to the least restrictive
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
     */

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    // JPA authentication and MySQL
     */

    @Autowired
    private UserDetailsService userDetailsService;

    // Authentication configuration
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);//This method enables you to pass an instance of a userDetailsService
    }

    //2- provide an encoder
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    // Authorization configuration
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //You specify accessibility from the most to the least restrictive
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
