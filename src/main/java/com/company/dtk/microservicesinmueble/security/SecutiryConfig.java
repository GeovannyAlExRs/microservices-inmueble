package com.company.dtk.microservicesinmueble.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class SecutiryConfig {

    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;


    @Value("${service.security.secure-key-username-2}")
    private String SECURE_KEY_USERNAME_2;

    @Value("${service.security.secure-key-password-2}")
    private String SECURE_KEY_PASSWORD_2;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(
                AuthenticationManagerBuilder.class
        );

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(SECURE_KEY_USERNAME)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser(SECURE_KEY_USERNAME_2)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_2))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DEV"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

        return httpSecurity.securityMatcher("/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .csrf()
                .disable()
                .httpBasic()
                .and()
                .build();
    }

    // Config CORS: to access to all endPoints from any origin
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
