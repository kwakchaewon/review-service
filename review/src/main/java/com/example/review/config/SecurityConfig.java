package com.example.review.config;

import com.example.review.jwt.JwtAccessDeniedHandler;
import com.example.review.jwt.JwtAuthenticationEntryPoint;
import com.example.review.jwt.JwtSecurityConfig;
import com.example.review.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig{

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(TokenProvider tokenProvider,
                          JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                          JwtAccessDeniedHandler jwtAccessDeniedHandler) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // csrf disable
//                .csrf((csrf) -> csrf
//                        .ignoringRequestMatchers(new AntPathRequestMatcher("**")))
                .csrf(AbstractHttpConfigurer::disable)

                // exceptionHandling
                .exceptionHandling((exceptionHandling)->exceptionHandling
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(jwtAccessDeniedHandler)
                )

                // h2 console 설정
//                .headers((headers)->headers
//                        .frameOptions()
//                        .sameOrigin()
//                )

                // sessionManagement: 세션 사용하지 않음
                .sessionManagement((sessionManagement)->sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // authorizeHttpRequests: 토큰 없는 URL 설정
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
//                        .requestMatchers("/api/hello", "/api/authenticate", "/api/signup").permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/hello")).permitAll()
                        .requestMatchers("/hello", "/api/authenticate","/api/signup").permitAll()
                        .anyRequest().authenticated()
                )

                .apply(new JwtSecurityConfig(tokenProvider));
        return http.build();
    }

}

