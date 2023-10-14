package com.wantedpreonboardingbackend.domain.announcement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementListResponse;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementRegisterRequestDto;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementResponse;
import com.wantedpreonboardingbackend.domain.announcement.dto.AnnouncementUpdateRequestDto;
import com.wantedpreonboardingbackend.domain.announcement.entity.Announcement;
import com.wantedpreonboardingbackend.domain.announcement.service.AnnouncementService;
import com.wantedpreonboardingbackend.domain.company.dto.CompanyRegisterRequestDto;
import com.wantedpreonboardingbackend.domain.company.entity.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AnnouncementControllerTest {

    @InjectMocks
    private AnnouncementController announcementController;
    @Mock
    private AnnouncementService announcementService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(announcementController).build();
    }

    @Test
    void 공고등록() throws Exception {

        AnnouncementRegisterRequestDto request = AnnouncementRegisterRequestDto.builder()
                .companyId(1L)
                .position("백엔드")
                .compensation(1000000L)
                .content("안녕하세요!")
                .skill("spring")
                .build();

        Mockito.when(announcementService.register(any(AnnouncementRegisterRequestDto.class))).thenReturn(1L);

        mockMvc.perform(post("/announcement")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/announcement/1"));
    }

    @Test
    void 공고수정() throws Exception {

        AnnouncementUpdateRequestDto request = AnnouncementUpdateRequestDto.builder()
                .skill("django")
                .build();

        Long announcementId = 1L;

        Mockito.doNothing().when(announcementService).update(request, announcementId);

        mockMvc.perform(patch("/announcement/{announcementId}", announcementId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void 공고삭제() throws Exception {
        Long announcementId = 1L; //

        Mockito.doNothing().when(announcementService).delete(announcementId);

        mockMvc.perform(delete("/announcement/{announcementId}", announcementId))
                .andExpect(status().isOk());
    }

    @Test
    void 공고리스트조회() throws Exception {
        List<AnnouncementListResponse> announcementList = new ArrayList<>();

        Mockito.when(announcementService.findAll()).thenReturn(announcementList);

        mockMvc.perform(get("/announcement"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(announcementList)));
    }

    @Test
    void 공고검색() throws Exception {
        String keyword = "test";
        List<AnnouncementListResponse> result = new ArrayList<>();

        Mockito.when(announcementService.search(keyword)).thenReturn(result);

        mockMvc.perform(get("/announcement/search")
                        .param("keyword", keyword))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(result)));
    }

    @Test
    void 공고상세조회() throws Exception {
        Long announcementId = 1L; // Set announcement ID
        AnnouncementResponse response = new AnnouncementResponse();

        Mockito.when(announcementService.findOne(announcementId)).thenReturn(response);

        mockMvc.perform(get("/announcement/{announcementId}", announcementId))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(response)));
    }








}