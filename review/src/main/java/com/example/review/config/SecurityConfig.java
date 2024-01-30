package com.example.review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // 스프링 시큐리티 구성 메서드로 HTTP 요청 인가 설정. HttpServeletRequest 사용 요청에 대한 접근 제한 설정
                .requestMatchers("/hello").permitAll() // 특정 매처를 지정해 특정 경로나 URL 패턴에 대한 인가 규칙을 설정 EX) /admin/**:
                .anyRequest().authenticated();

        return http.build();
    }

}

