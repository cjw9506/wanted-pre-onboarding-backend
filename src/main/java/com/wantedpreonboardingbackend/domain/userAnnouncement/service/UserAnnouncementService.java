package com.wantedpreonboardingbackend.domain.userAnnouncement.service;

import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import com.wantedpreonboardingbackend.domain.announcement.exception.AnnouncementNotFound;
import com.wantedpreonboardingbackend.domain.announcement.repository.AnnouncementRepository;
import com.wantedpreonboardingbackend.domain.user.entity.User;
import com.wantedpreonboardingbackend.domain.user.exception.UserNotFound;
import com.wantedpreonboardingbackend.domain.user.repository.UserRepository;
import com.wantedpreonboardingbackend.domain.userAnnouncement.dto.ApplyRequest;
import com.wantedpreonboardingbackend.domain.userAnnouncement.entity.UserAnnouncement;
import com.wantedpreonboardingbackend.domain.userAnnouncement.exception.AlreadyApplyException;
import com.wantedpreonboardingbackend.domain.userAnnouncement.repository.UserAnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAnnouncementService {

    private final UserAnnouncementRepository userAnnouncementRepository;
    private final UserRepository userRepository;
    private final AnnouncementRepository announcementRepository;

    @Transactional
    public Long apply(ApplyRequest request) {

        Announcement announcement = announcementRepository.findById(request.getAnnouncementId()).orElseThrow(AnnouncementNotFound::new);
        User user = userRepository.findById(request.getUserId()).orElseThrow(UserNotFound::new);

        //1회만 지원가능하게 함.
        if (userAnnouncementRepository.findByAnnouncementIdAndUserId(request.getAnnouncementId(), request.getUserId()).isPresent()) {
            throw new AlreadyApplyException();
        }

        UserAnnouncement apply = UserAnnouncement.builder()
                .announcement(announcement)
                .user(user)
                .build();

        return userAnnouncementRepository.save(apply).getId();



    }
}
