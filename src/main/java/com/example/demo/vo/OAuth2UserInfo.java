package com.example.demo.vo;

public interface OAuth2UserInfo {
    // "kakao", "naver"
    String getProviderId();
    // kakao와 facebook의 id값, naver의 response의 id 값
    String getProvider();
    // kakao의 kakao_account의 email값, naver의 response의 email값
    String getEmail();
    // kakao properties = {nickname=안창범}, naver response의 name
    String getName();
}
