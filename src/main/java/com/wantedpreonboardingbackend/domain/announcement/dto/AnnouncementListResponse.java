package com.wantedpreonboardingbackend.domain.announcement.dto;

import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import lombok.Getter;

@Getter
public class AnnouncementListResponse {

    private Long announcementId;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private Long compensation;
    private String skill;

    public AnnouncementListResponse(Announcement announcement) {
        this.announcementId = announcement.getId();
        this.companyName = announcement.getCompany().getName();
        this.nation = announcement.getCompany().getNation();
        this.region = announcement.getCompany().getRegion();
        this.position = announcement.getPosition();
        this.compensation = announcement.getCompensation();
        this.skill = announcement.getSkill();

    }

}
