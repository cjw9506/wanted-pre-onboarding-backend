package com.wantedpreonboardingbackend.domain.announcement.repository;

import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;

import java.util.List;

public interface AnnouncementRepositoryCustom {

    List<Announcement> search(String keyword);
}
