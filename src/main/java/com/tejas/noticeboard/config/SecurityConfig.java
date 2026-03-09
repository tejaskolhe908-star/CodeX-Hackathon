package com.tejas.noticeboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/notice/add").hasRole("ADMIN")
                    .requestMatchers("/notice/update/**").hasRole("ADMIN")
                    .requestMatchers("/notice/delete/**").hasRole("ADMIN")
                    .requestMatchers("/notice/student").hasAnyRole("STUDENT","ADMIN")
                    .requestMatchers("/notice/faculty").hasAnyRole("FACULTY","ADMIN")
                    .anyRequest().authenticated()
            )
            .httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        UserDetails student = User.withUsername("student")
                .password("{noop}student123")
                .roles("STUDENT")
                .build();

        UserDetails faculty = User.withUsername("faculty")
                .password("{noop}faculty123")
                .roles("FACULTY")
                .build();

        return new InMemoryUserDetailsManager(admin, student, faculty);
    }
}