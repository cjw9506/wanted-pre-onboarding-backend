package com.wantedpreonboardingbackend.domain.userAnnouncement.service;

import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import com.wantedpreonboardingbackend.domain.announcement.repository.AnnouncementRepository;
import com.wantedpreonboardingbackend.domain.user.entity.User;
import com.wantedpreonboardingbackend.domain.user.repository.UserRepository;
import com.wantedpreonboardingbackend.domain.userAnnouncement.dto.ApplyRequest;
import com.wantedpreonboardingbackend.domain.userAnnouncement.entity.UserAnnouncement;
import com.wantedpreonboardingbackend.domain.userAnnouncement.exception.AlreadyApplyException;
import com.wantedpreonboardingbackend.domain.userAnnouncement.repository.UserAnnouncementRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserAnnouncementServiceTest {

    @InjectMocks
    private UserAnnouncementService userAnnouncementService;

    @Mock
    private UserAnnouncementRepository userAnnouncementRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AnnouncementRepository announcementRepository;

    @Test
    void 공고지원() {
        ApplyRequest request = ApplyRequest.builder()
                .announcementId(1L)
                .userId(2L)
                .build();

        Announcement announcement = Announcement.builder().id(1L).build();
        User user = User.builder().id(2L).build();

        Mockito.when(announcementRepository.findById(1L)).thenReturn(Optional.of(announcement));
        Mockito.when(userRepository.findById(2L)).thenReturn(Optional.of(user));
        Mockito.when(userAnnouncementRepository.findByAnnouncementIdAndUserId(1L, 2L)).thenReturn(Optional.empty());

        UserAnnouncement apply = UserAnnouncement.builder().id(1L).build();
        Mockito.when(userAnnouncementRepository.save(Mockito.any(UserAnnouncement.class))).thenReturn(apply);

        Long applyId = userAnnouncementService.apply(request);

        Assertions.assertEquals(1L, applyId);
    }

    @Test
    void 공고지원_중복검사() {
        ApplyRequest request = ApplyRequest.builder()
                .announcementId(1L)
                .userId(2L)
                .build();

        Announcement announcement = Announcement.builder().id(1L).build();
        User user = User.builder().id(2L).build();

        Mockito.when(announcementRepository.findById(1L)).thenReturn(Optional.of(announcement));
        Mockito.when(userRepository.findById(2L)).thenReturn(Optional.of(user));
        Mockito.when(userAnnouncementRepository.findByAnnouncementIdAndUserId(1L, 2L)).thenReturn(Optional.of(new UserAnnouncement()));

        Assertions.assertThrows(AlreadyApplyException.class, () -> {
            userAnnouncementService.apply(request);
        });
    }
}