package com.wantedpreonboardingbackend.domain.announcement.dto;

import lombok.Getter;

@Getter
public class AnnouncementUpdateRequestDto {

    private String position;
    private Long compensation;
    private String content;
    private String skill;
}
