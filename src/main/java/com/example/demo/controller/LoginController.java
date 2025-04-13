package com.example.demo.controller;

import com.example.demo.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @ResponseBody
    @GetMapping("/test/oauth/login")
    public String testOAuthLogin(
            Authentication authentication,
            @AuthenticationPrincipal OAuth2User oauth) { //세션 정보 받아오기 (DI 의존성 주입)

        //방법 1
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication: " + oAuth2User.getAttributes());

        //방법 2
        System.out.println("OAuth2User:" + oauth.getAttributes());

        return "OAuth 세션 정보 확인";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute User user){
        user.setRole(Role.USER);
        //user.setRole("USER");
        user.setCreateDate(LocalDateTime.now());

        String rawPassword = user.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);

        user.setPassword(encPassword);
        userRepository.save(user);

        return "redirect:/loginForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }
}
