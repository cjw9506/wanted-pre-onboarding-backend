package com.wantedpreonboardingbackend.domain.userAnnouncement.repository;

import com.wantedpreonboardingbackend.domain.userAnnouncement.entity.UserAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAnnouncementRepository extends JpaRepository<UserAnnouncement, Long> {

    Optional<UserAnnouncement> findByAnnouncementIdAndUserId(Long announcementId, Long userId);

}
