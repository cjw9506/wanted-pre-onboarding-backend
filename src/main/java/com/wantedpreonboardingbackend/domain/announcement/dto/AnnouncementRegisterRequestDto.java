package com.wantedpreonboardingbackend.domain.announcement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AnnouncementRegisterRequestDto {

    @NotNull(message = "회사명은 필수입니다.")
    private Long companyId;

    @NotBlank(message = "채용 포지션을 입력해주세요.")
    private String position;

    @NotNull(message = "채용 보상금을 입력해주세요.")
    private Long compensation;

    @NotBlank(message = "채용 내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "사용 기술을 입력해주세요.")
    private String skill;
}
