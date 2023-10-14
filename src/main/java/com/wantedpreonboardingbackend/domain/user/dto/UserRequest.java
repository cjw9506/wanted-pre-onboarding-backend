package com.wantedpreonboardingbackend.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "이름은 필수입니다.")
    @Length(min = 2)
    private String name;

    @NotNull(message = "나이는 필수입니다.")
    private int age;

    @NotBlank(message = "연락처는 필수입니다.")
    private String contact;

    @NotBlank(message = "희망 포지션은 필수입니다.")
    private String position;

    @NotBlank(message = "자기소개서는 필수입니다.")
    private String content;

    @Builder
    public UserRequest(String name, int age, String contact, String position, String content) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.position = position;
        this.content = content;
    }
}
