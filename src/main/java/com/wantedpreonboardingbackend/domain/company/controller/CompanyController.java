package com.wantedpreonboardingbackend.domain.company.controller;

import com.wantedpreonboardingbackend.domain.company.dto.CompanyRegisterRequestDto;
import com.wantedpreonboardingbackend.domain.company.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<?> register(@Valid @RequestBody CompanyRegisterRequestDto request) {

        Long companyId = companyService.register(request);

        return ResponseEntity.created(URI.create("/company/" + companyId)).build();
    }
}
