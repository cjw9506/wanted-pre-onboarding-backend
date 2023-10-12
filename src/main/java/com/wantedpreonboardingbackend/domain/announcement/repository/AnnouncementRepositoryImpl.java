package com.wantedpreonboardingbackend.domain.announcement.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import com.wantedpreonboardingbackend.domain.announcement.entity.QAnnouncement;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AnnouncementRepositoryImpl implements AnnouncementRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Announcement> search(String keyword) {
        return jpaQueryFactory.selectFrom(QAnnouncement.announcement)
                .where(QAnnouncement.announcement.company.name.like("%" + keyword + "%")
                        .or(QAnnouncement.announcement.company.nation.like("%" + keyword + "%"))
                        .or(QAnnouncement.announcement.company.region.like("%" + keyword + "%"))
                        .or(QAnnouncement.announcement.position.like("%" + keyword + "%"))
                        .or(QAnnouncement.announcement.skill.like("%" + keyword + "%"))
                )
                .fetch();
    }
}
