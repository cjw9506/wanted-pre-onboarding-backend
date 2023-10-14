package com.wantedpreonboardingbackend.domain.announcement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnnouncementUpdateRequestDto {

    private String position;
    private Long compensation;
    private String content;
    private String skill;

    @Builder
    public AnnouncementUpdateRequestDto(String position, Long compensation, String content, String skill) {
        this.position = position;
        this.compensation = compensation;
        this.content = content;
        this.skill = skill;
    }
}
