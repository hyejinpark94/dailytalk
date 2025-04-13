package com.example.demo.config;

import com.example.demo.service.login.PrincipalOauthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private PrincipalOauthUserService principalOauthUserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // CSRF 설정
            .csrf(csrf -> csrf.disable()) // csrf 비활성화

            // 요청 권한 설정
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/user/**").authenticated()
                    .requestMatchers("/manager/**").hasAuthority("MANAGER")
                    .requestMatchers("/admin/**").hasAuthority("ADMIN")
                    .requestMatchers("/pages/authentication/sign-in").permitAll() // React 로그인 페이지 접근 허용
                    .anyRequest().authenticated() // 나머지 요청은 인증 필요
            )

            // Form 로그인 설정
            .formLogin(form -> form
                    .loginPage("/loginForm") // 미인증 사용자가 접근 시 호출될 페이지
                    .loginProcessingUrl("/login") // 로그인 처리 URL (POST 요청)
                    .defaultSuccessUrl("/") // 로그인 성공 시 이동할 기본 URL
            )

            // OAuth2 로그인 설정
            .oauth2Login(oauth2 -> oauth2
                    .loginPage("/pages/authentication/sign-in") // React 로그인 페이지 경로 설정
                    //.loginPage("/loginForm") // OAuth2 로그인 페이지 설정
                    .defaultSuccessUrl("/") // 로그인 성공 후 이동할 URL
                    .userInfoEndpoint(userInfo -> userInfo.userService(principalOauthUserService)) // 사용자 서비스 설정
            );
        return http.build();
    }
}
