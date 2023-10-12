package com.wantedpreonboardingbackend.domain.announcement.service;

import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementRegisterRequestDto;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementListResponse;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementResponse;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementUpdateRequestDto;
import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import com.wantedpreonboardingbackend.domain.announcement.repository.AnnouncementRepository;
import com.wantedpreonboardingbackend.domain.company.entity.Company;
import com.wantedpreonboardingbackend.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public Long register(AnnouncementRegisterRequestDto request) {

        Company company = companyRepository.findById(request.getCompanyId()).
                orElseThrow(IllegalStateException::new);

        Announcement announcement = Announcement.builder()
                .company(company)
                .position(request.getPosition())
                .compensation(request.getCompensation())
                .content(request.getContent())
                .skill(request.getSkill())
                .build();

        announcementRepository.save(announcement);

        return announcement.getId();
    }

    @Transactional
    public void update(AnnouncementUpdateRequestDto request, Long announcementId) {

        Announcement announcement = announcementRepository.findById(announcementId).orElseThrow(IllegalStateException::new);

        announcement.updateAnnouncement(request);
    }

    @Transactional
    public void delete(Long announcementId) {

        Announcement announcement = announcementRepository.findById(announcementId).orElseThrow(IllegalStateException::new);

        announcementRepository.delete(announcement);
    }

    public List<AnnouncementListResponse> findAll() {

        return announcementRepository.findAll().stream()
                .map(AnnouncementListResponse::new)
                .collect(Collectors.toList());

    }


    public List<AnnouncementListResponse> search(String keyword) {

        return announcementRepository.search(keyword).stream()
                .map(AnnouncementListResponse::new)
                .collect(Collectors.toList());

    }

    public AnnouncementResponse findOne(Long announcementId) {

        Announcement announcement = announcementRepository.findById(announcementId).orElseThrow(IllegalStateException::new);
        List<Announcement> list = announcementRepository.findByCompanyId(announcement.getCompany().getId());

        List<Long> announcementIds = list.stream()
                .map(Announcement::getId)
                .filter(id -> !id.equals(announcement.getId()))
                .collect(Collectors.toList());

        AnnouncementResponse response = AnnouncementResponse.builder()
                .announcementId(announcement.getId())
                .companyName(announcement.getCompany().getName())
                .nation(announcement.getCompany().getNation())
                .region(announcement.getCompany().getRegion())
                .position(announcement.getPosition())
                .compensation(announcement.getCompensation())
                .skill(announcement.getSkill())
                .content(announcement.getContent())
                .otherAnnouncements(announcementIds)
                .build();

        return response;

    }
}
