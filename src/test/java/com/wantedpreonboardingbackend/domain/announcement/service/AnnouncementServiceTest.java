package com.wantedpreonboardingbackend.domain.announcement.service;

import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementListResponse;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementRegisterRequestDto;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementResponse;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementUpdateRequestDto;
import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import com.wantedpreonboardingbackend.domain.announcement.repository.AnnouncementRepository;
import com.wantedpreonboardingbackend.domain.company.entity.Company;
import com.wantedpreonboardingbackend.domain.company.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AnnouncementServiceTest {
    @InjectMocks
    private AnnouncementService announcementService;
    @Mock
    private AnnouncementRepository announcementRepository;
    @Mock
    private CompanyRepository companyRepository;

    @Test
    void 공고등록() {

        AnnouncementRegisterRequestDto request = AnnouncementRegisterRequestDto.builder()
                .companyId(1L)
                .position("TestPosition")
                .compensation(1000L)
                .content("TestContent")
                .skill("TestSkill")
                .build();

        Company company = Company.builder()
                .id(1L)
                .name("TestCompany")
                .nation("TestNation")
                .region("TestRegion")
                .build();

        Announcement announcement = Announcement.builder()
                .id(1L)
                .company(company)
                .position(request.getPosition())
                .compensation(request.getCompensation())
                .content(request.getContent())
                .skill(request.getSkill())
                .build();

        Mockito.when(companyRepository.findById(request.getCompanyId())).thenReturn(Optional.of(company));
        Mockito.when(announcementRepository.save(Mockito.any(Announcement.class))).thenReturn(announcement);

        Long announcementId = announcementService.register(request);
        Assertions.assertEquals(announcementId, 1L);
    }

    @Test
    void 공고수정() {
        AnnouncementUpdateRequestDto request = AnnouncementUpdateRequestDto.builder()
                .skill("UpdatedSkill")
                .build();

        Announcement mockAnnouncement = Announcement.builder()
                .id(1L)
                .position("TestPosition")
                .compensation(1000L)
                .content("TestContent")
                .skill("TestSkill")
                .build();

        Mockito.when(announcementRepository.findById(1L)).thenReturn(Optional.of(mockAnnouncement));

        announcementService.update(request, 1L);

        Assertions.assertEquals("UpdatedSkill", mockAnnouncement.getSkill());
    }

    @Test
    void 공고삭제() {
        Announcement announcement = Announcement.builder()
                .id(1L)
                .position("TestPosition")
                .compensation(1000L)
                .content("TestContent")
                .skill("TestSkill")
                .build();

        Mockito.when(announcementRepository.findById(1L)).thenReturn(Optional.of(announcement));

        announcementService.delete(1L);

        Mockito.verify(announcementRepository, Mockito.times(1)).delete(announcement);
    }

    @Test
    void 공고리스트조회() {

        Company company = Company.builder()
                .id(1L)
                .name("TestCompany")
                .nation("TestNation")
                .region("TestRegion")
                .build();

        Announcement announcement = Announcement.builder()
                .id(1L)
                .company(company)
                .position("TestPosition")
                .compensation(1000L)
                .content("TestContent")
                .skill("TestSkill")
                .build();

        Mockito.when(announcementRepository.findAll()).thenReturn(Collections.singletonList(announcement));

        List<AnnouncementListResponse> announcementList = announcementService.findAll();

        Assertions.assertEquals(1, announcementList.size());
    }

    @Test
    void 공고검색() {

        Company company = Company.builder()
                .id(1L)
                .name("TestCompany")
                .nation("TestNation")
                .region("TestRegion")
                .build();

        Announcement announcement = Announcement.builder()
                .id(1L)
                .company(company)
                .position("TestPosition")
                .compensation(1000L)
                .content("TestContent")
                .skill("TestSkill")
                .build();

        Mockito.when(announcementRepository.search("Keyword")).thenReturn(Collections.singletonList(announcement));

        List<AnnouncementListResponse> announcementList = announcementService.search("Keyword");

        Assertions.assertEquals(1, announcementList.size());
    }

    @Test
    void 공고상세조회() {
        Company company = Company.builder()
                .id(1L)
                .name("TestCompany")
                .nation("TestNation")
                .region("TestRegion")
                .build();

        Announcement announcement = Announcement.builder()
                .id(1L)
                .company(company)
                .position("TestPosition")
                .compensation(1000L)
                .content("TestContent")
                .skill("TestSkill")
                .build();

        List<Announcement> announcementList = Collections.singletonList(
                Announcement.builder()
                        .id(2L)
                        .position("OtherPosition")
                        .compensation(2000L)
                        .content("OtherContent")
                        .skill("OtherSkill")
                        .build()
        );

        Mockito.when(announcementRepository.findById(1L)).thenReturn(Optional.of(announcement));
        Mockito.when(announcementRepository.findByCompanyId(1L)).thenReturn(announcementList);

        AnnouncementResponse response = announcementService.findOne(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1L, response.getAnnouncementId());
        Assertions.assertEquals("TestCompany", response.getCompanyName());
        Assertions.assertEquals("TestNation", response.getNation());
        Assertions.assertEquals("TestRegion", response.getRegion());
        Assertions.assertEquals("TestPosition", response.getPosition());
        Assertions.assertEquals(1000L, response.getCompensation());
        Assertions.assertEquals("TestSkill", response.getSkill());
        Assertions.assertEquals("TestContent", response.getContent());
        Assertions.assertEquals(1, response.getOtherAnnouncements().size());
        Assertions.assertEquals(2L, response.getOtherAnnouncements().get(0));
    }

}