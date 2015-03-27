package com.edu.thesis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


/**
 * Created by Oleg on 15.01.2015.
 */
@Configuration
@EnableWebSecurity
//@Import(DBConfiguration.class)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
//http://stoflru.org/questions/25388855/spring-security-with-database-authorization-with-java-configuration
//http://www.mkyong.com/spring-security/spring-security-hello-world-annotation-example/

    @Autowired
    private DataSource dataSource;

    /*@Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource).usersByUsernameQuery("select login, password " +
                "from user_of_the_group " +
                "where login=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')")
                .and().formLogin().defaultSuccessUrl("/", false);

    }*/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin();

    }
}
