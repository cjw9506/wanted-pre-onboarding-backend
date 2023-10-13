package com.wantedpreonboardingbackend.domain.company.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CompanyRegisterRequestDto {

    @NotBlank(message = "회사명을 입력해주세요.")
    private String name;

    @NotBlank(message = "국가를 입력해주세요.")
    private String nation;

    @NotBlank(message = "지역을 입력해주세요.")
    private String region;

    @Builder
    public CompanyRegisterRequestDto(String name, String nation, String region) {
        this.name = name;
        this.nation = nation;
        this.region = region;
    }
}
