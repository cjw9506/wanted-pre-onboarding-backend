package com.wantedpreonboardingbackend.domain.company.repository;

import com.wantedpreonboardingbackend.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
