package com.wantedpreonboardingbackend.domain.userAnnouncement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wantedpreonboardingbackend.domain.company.dto.CompanyRegisterRequestDto;
import com.wantedpreonboardingbackend.domain.userAnnouncement.dto.ApplyRequest;
import com.wantedpreonboardingbackend.domain.userAnnouncement.service.UserAnnouncementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserAnnouncementControllerTest {

    @InjectMocks
    private UserAnnouncementController userAnnouncementController;

    @Mock
    private UserAnnouncementService userAnnouncementService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userAnnouncementController).build();
    }


    @Test
    void 공고지원() throws Exception {

        ApplyRequest request = ApplyRequest.builder()
                .userId(1L)
                .announcementId(1L)
                .build();

        Mockito.when(userAnnouncementService.apply(any(ApplyRequest.class))).thenReturn(1L);

        mockMvc.perform(post("/apply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/apply/1"));
    }


}