package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/books", "/search", "/css/**", "/js/**").permitAll()
                .requestMatchers("/api/**").permitAll() 
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .defaultSuccessUrl("/books", true)
                .permitAll()
            )
            .logout(logout -> logout.permitAll())
            .httpBasic(withDefaults());
        
        return http.build();
    }
}
