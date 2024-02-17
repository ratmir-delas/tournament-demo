package com.tournament.math.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    private final List<String> addresses = List.of(new String[]{"/", "f"});
    private List<String> requestMatchers = List.of(new String[]{});

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        for (String requestMatcher : requestMatchers) {
            String apiVersion = "/api/v1";
            addresses.add(apiVersion + requestMatcher);
        }

        http
            // Contains methods deprecated in Spring Security 6.1
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .requestMatchers((RequestMatcher) addresses)
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}