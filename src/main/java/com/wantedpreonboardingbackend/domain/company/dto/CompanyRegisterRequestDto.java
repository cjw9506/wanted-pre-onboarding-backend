package com.wantedpreonboardingbackend.domain.company.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CompanyRegisterRequestDto {

    @NotBlank(message = "회사명을 입력해주세요.")
    private String name;

    @NotBlank(message = "국가를 입력해주세요.")
    private String nation;

    @NotBlank(message = "지역을 입력해주세요.")
    private String region;
}
