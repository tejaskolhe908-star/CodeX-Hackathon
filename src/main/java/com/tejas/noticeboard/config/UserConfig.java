package com.tejas.noticeboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService users() {

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails faculty = User.withDefaultPasswordEncoder()
                .username("faculty")
                .password("faculty123")
                .roles("FACULTY")
                .build();

        UserDetails student = User.withDefaultPasswordEncoder()
                .username("student")
                .password("student123")
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(admin, faculty, student);
    }
}