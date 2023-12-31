package com.wantedpreonboardingbackend.domain.company.entity;

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
public class Company {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nation;

    private String region;

    @Builder
    public Company(Long id, String name, String nation, String region) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.region = region;
    }
}
