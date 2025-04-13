package com.example.demo.controller;

import com.example.demo.dto.KakaoUserInfoResponseDto;
import com.example.demo.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login/oauth2/code")
public class OAuth2LoginController {

    private final KakaoLoginService kakaoLoginService;

    @GetMapping("/kakao")
    public ResponseEntity<?> kakaoCode(@RequestParam("code") String code) throws IOException {
        String accessToken = kakaoLoginService.getAccessTokenFromKakao(code);
        KakaoUserInfoResponseDto userInfo = kakaoLoginService.getUserInfo(accessToken);

        // 여기에 서버 사용자 로그인(인증) 또는 회원가입 로직 추가

        // "login" 으로 redirect 시켜줘야 알아서 넘어가나?

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/naver")
    public ResponseEntity<?> naverCode(@RequestParam("code") String code) throws IOException {
        //String accessToken = kakaoService.getAccessTokenFromKakao(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
