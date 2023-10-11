package com.wantedpreonboardingbackend.domain.company.service;

import com.wantedpreonboardingbackend.domain.company.dto.CompanyRegisterResponseDto;
import com.wantedpreonboardingbackend.domain.company.entity.Company;
import com.wantedpreonboardingbackend.domain.company.dto.CompanyRegisterRequestDto;
import com.wantedpreonboardingbackend.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public Long register(CompanyRegisterRequestDto request) {

        Company company = Company.builder()
                .name(request.getName())
                .nation(request.getNation())
                .region(request.getRegion())
                .build();

        companyRepository.save(company);

        return company.getId();
    }
}
