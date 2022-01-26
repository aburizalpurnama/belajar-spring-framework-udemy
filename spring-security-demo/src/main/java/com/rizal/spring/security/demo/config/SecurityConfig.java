package com.rizal.spring.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Berbeda dengan yang ada di course, karena tidak seperti course yang menggunakan plain password,
 * di sini menggunakan hashing dengan bcrypt
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource);
//                .passwordEncoder(passwordEncoder());

        // add users in memory authentication
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())
//                .withUser("rizal").password(getHashedPassword("rizal123")).roles("MANAGER").and()
//                .withUser("tohir").password(getHashedPassword("tohir123")).roles("EMPLOYEE").and()
//                .withUser("jamal").password(getHashedPassword("jamal123")).roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // configure custome login page
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and().formLogin()
                    .loginPage("/showLoginPage")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll()
                .and().exceptionHandling()
                    .accessDeniedPage("/accessDenied")
                .and().logout().permitAll();
    }

    @Bean
    @Autowired
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(5);
    }

    private String getHashedPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(5));
    }
}
