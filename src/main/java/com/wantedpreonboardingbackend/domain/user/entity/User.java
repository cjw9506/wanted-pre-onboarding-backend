package com.wantedpreonboardingbackend.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String contact;

    private String position;

    private String content;

    @Builder
    public User(Long id, String name, int age, String contact, String position, String content) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.position = position;
        this.content = content;
    }
}
