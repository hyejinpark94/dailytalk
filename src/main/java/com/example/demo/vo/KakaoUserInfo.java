package com.example.demo.vo;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class KakaoUserInfo implements OAuth2UserInfo {

    private String id;
    private Map<String, Object> kakaoAccount;

    public KakaoUserInfo(Map<String, Object> attributes, String id ) {
        this.kakaoAccount = attributes;
        this.id = id;
    }

//    @Override
//    public String getProviderId() {
//        // Long 타입이기 때문에 toString으로 변호나
//        return kakaoAccount.get("id").toString();
//    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return id;
    }

    @Override
    public String getEmail() {
        // kakao_account라는 Map에서 추출
        return (String) ((Map) kakaoAccount.get("kakao_account")).get("email");
    }

    @Override
    public String getName() {
        // kakao_account라는 Map에서 추출
        return (String) ((Map) kakaoAccount.get("properties")).get("nickname");
    }
}
