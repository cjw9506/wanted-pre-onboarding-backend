package com.wantedpreonboardingbackend.domain.announcement.controller;

import com.wantedpreonboardingbackend.domain.announcement.dto.*;
import com.wantedpreonboardingbackend.domain.announcement.service.AnnouncementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping("/announcement")
    public ResponseEntity<?> register(@Valid @RequestBody AnnouncementRegisterRequestDto request) {
        Long announcementId = announcementService.register(request);

        return ResponseEntity.created(URI.create("/announcement/" + announcementId)).build();
    }

    @PatchMapping("/announcement/{announcementId}")
    public ResponseEntity<?> update(@RequestBody AnnouncementUpdateRequestDto request,
                                    @PathVariable Long announcementId) {
        announcementService.update(request, announcementId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/announcement/{announcementId}")
    public ResponseEntity<?> delete(@PathVariable Long announcementId) {
        announcementService.delete(announcementId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/announcement")
    public ResponseEntity<?> getAll() {

        List<AnnouncementListResponse> announcementList = announcementService.findAll();

        return ResponseEntity.ok().body(announcementList);
    }

    @GetMapping("/announcement/search")
    public ResponseEntity<?> search(@RequestParam("keyword") String keyword) {

        List<AnnouncementListResponse> result = announcementService.search(keyword);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/announcement/{announcementId}")
    public ResponseEntity<?> getOne(@PathVariable Long announcementId) {

        AnnouncementResponse response = announcementService.findOne(announcementId);

        return ResponseEntity.ok().body(response);
    }
}
