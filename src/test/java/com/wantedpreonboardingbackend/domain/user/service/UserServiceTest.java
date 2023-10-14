package com.wantedpreonboardingbackend.domain.user.service;

import com.wantedpreonboardingbackend.domain.user.dto.UserRequest;
import com.wantedpreonboardingbackend.domain.user.entity.User;
import com.wantedpreonboardingbackend.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void 회원등록() {
        UserRequest request = UserRequest.builder()
                .name("TestName")
                .age(29)
                .contact("01053109506")
                .position("백엔드")
                .content("안녕하세요!")
                .build();

        User user = User.builder()
                .id(1L)
                .name(request.getName())
                .age(request.getAge())
                .position(request.getPosition())
                .content(request.getContent())
                .contact(request.getContact())
                .build();

        when(userRepository.save(any(User.class))).thenReturn(user);

        Long userId = userService.register(request);

        assertEquals(1L, userId);
    }


}