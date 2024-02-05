package com.scbcompany.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails salih=User.builder().username("salihbstg").password("{noop}salih1213.").roles("admin","manager","employee").build();
//        UserDetails tuce=User.builder().username("tuce").password("{noop}salih1213.").roles("admin","manager","employee").build();
//        UserDetails sezin=User.builder().username("gizem").password("{noop}salih1213.").roles("manager","employee").build();
//        UserDetails gorki=User.builder().username("gorkem").password("{noop}salih1213.").roles("employee").build();
//        return new InMemoryUserDetailsManager(salih,tuce,sezin,gorki);
//    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
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
