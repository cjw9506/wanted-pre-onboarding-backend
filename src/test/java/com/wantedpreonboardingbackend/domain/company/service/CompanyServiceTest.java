package com.wantedpreonboardingbackend.domain.company.service;

import com.wantedpreonboardingbackend.domain.company.dto.CompanyRegisterRequestDto;
import com.wantedpreonboardingbackend.domain.company.entity.Company;
import com.wantedpreonboardingbackend.domain.company.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    void 회사등록() {

        CompanyRegisterRequestDto request = CompanyRegisterRequestDto.builder()
                .name("TestName")
                .nation("TestNation")
                .region("TestRegion")
                .build();

        Company savedCompany = Company.builder()
                .id(1L)
                .name(request.getName())
                .nation(request.getNation())
                .region(request.getRegion())
                .build();

        when(companyRepository.save(any(Company.class))).thenReturn(savedCompany);

        Long companyId = companyService.register(request);

        assertEquals(1L, companyId);
    }
}
