package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("ROLE_ADMIN", "관리자"),
    MANAGER("ROLE_MANAGER", "매니저"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;   // 권한 키 (예: ROLE_ADMIN)
    private final String title; // 역할 설명
}
