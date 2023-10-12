package com.wantedpreonboardingbackend.domain.announcement.dto;

import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AnnouncementResponse {

    private Long announcementId;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private Long compensation;
    private String skill;
    private String content;
    private List<Long> otherAnnouncements;

    @Builder
    public AnnouncementResponse(Long announcementId, String companyName,
                                String nation, String region, String position,
                                Long compensation, String skill, String content,
                                List<Long> otherAnnouncements) {
        this.announcementId = announcementId;
        this.companyName = companyName;
        this.nation = nation;
        this.region = region;
        this.position = position;
        this.compensation = compensation;
        this.skill = skill;
        this.content = content;
        this.otherAnnouncements = otherAnnouncements;
    }
}
