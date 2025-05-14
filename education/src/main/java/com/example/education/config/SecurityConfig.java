package com.example.education.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder encoder) {
        UserDetails admin = User
                .withUsername("admin")
                .password(encoder.encode("adminpass"))
                .roles("admin")
                .build();

        UserDetails support = User
                .withUsername("support")
                .password(encoder.encode("supportpass"))
                .roles("support")
                .build();

        return new InMemoryUserDetailsManager(admin, support);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/public/api").permitAll()
                .requestMatchers("/admin/api").hasRole("admin")
                .requestMatchers("/support/api").hasRole("support")
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();
    }
}
