package com.wantedpreonboardingbackend.domain.announcement.repository;

import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long>, AnnouncementRepositoryCustom {

    List<Announcement> findByCompanyId(Long companyId);
}
