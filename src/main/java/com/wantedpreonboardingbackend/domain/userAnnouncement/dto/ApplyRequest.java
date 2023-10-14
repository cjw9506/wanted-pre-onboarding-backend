package com.wantedpreonboardingbackend.domain.userAnnouncement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplyRequest {

    private Long announcementId;
    private Long userId;

    @Builder
    public ApplyRequest(Long announcementId, Long userId) {
        this.announcementId = announcementId;
        this.userId = userId;
    }
}
