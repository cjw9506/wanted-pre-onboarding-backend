package com.wantedpreonboardingbackend.domain.userAnnouncement.controller;

import com.wantedpreonboardingbackend.domain.userAnnouncement.dto.ApplyRequest;
import com.wantedpreonboardingbackend.domain.userAnnouncement.service.UserAnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserAnnouncementController {

    private final UserAnnouncementService userAnnouncementService;

    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody ApplyRequest request) {

        Long applyId = userAnnouncementService.apply(request);

        return ResponseEntity.created(URI.create("/announcement/apply/" + applyId)).build();
    }
}
