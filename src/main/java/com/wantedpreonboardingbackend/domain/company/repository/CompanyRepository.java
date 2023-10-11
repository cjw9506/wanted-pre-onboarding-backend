package com.wantedpreonboardingbackend.domain.company.repository;

import com.wantedpreonboardingbackend.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String companyName);
}
