package com.wantedpreonboardingbackend.domain.announcement.entity;

import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementUpdateRequestDto;
import com.wantedpreonboardingbackend.domain.company.entity.Company;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Announcement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    //채용 포지션
    private String position;

    //보상금
    private Long compensation;

    //채용 내용
    private String content;

    //사용 기술
    private String skill;

    @Builder
    public Announcement(Company company, String position, Long compensation, String content, String skill) {
        this.company = company;
        this.position = position;
        this.compensation = compensation;
        this.content = content;
        this.skill = skill;
    }

    //공고 업데이트
    public void updateAnnouncement(AnnouncementUpdateRequestDto request) {
        if (request.getPosition() != null) {
            this.position = request.getPosition();
        }
        if (request.getCompensation() != null) {
            this.compensation = request.getCompensation();
        }
        if (request.getContent() != null) {
            this.content = request.getContent();
        }
        if (request.getSkill() != null) {
            this.skill = request.getSkill();
        }
    }

}
