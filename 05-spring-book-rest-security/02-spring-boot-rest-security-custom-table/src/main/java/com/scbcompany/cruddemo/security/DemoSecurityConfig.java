package com.scbcompany.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username,password,enabled from users where username=?");

        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username,authority from authorities where username=?");

        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN")
                );
        //use basic authentication
        http.httpBasic(Customizer.withDefaults());

       //disable cross site request forgery
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
