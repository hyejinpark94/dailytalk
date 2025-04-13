package com.example.demo.entity;

import com.example.demo.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Entity @Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role; //ADMIN, MANAGER, USER

    @Column
    private String provider; //어떤 OAuth인지(google, naver 등)

    @Column
    private String providerId; // 해당 OAuth 의 key(id)

    private LocalDateTime createDate;

    @Column
    private String loginId;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    @Builder
    public User(String username, String password, String email, Role role, String provider, String providerId, LocalDateTime createDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.createDate = createDate;
    }
}
