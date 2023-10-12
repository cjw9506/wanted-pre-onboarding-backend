package com.wantedpreonboardingbackend.domain.user.service;

import com.wantedpreonboardingbackend.domain.user.dto.UserRequest;
import com.wantedpreonboardingbackend.domain.user.entity.User;
import com.wantedpreonboardingbackend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long register(UserRequest request) {

        User user = User.builder()
                .name(request.getName())
                .age(request.getAge())
                .contact(request.getContact())
                .position(request.getPosition())
                .content(request.getContent())
                .build();

        userRepository.save(user);

        return user.getId();
    }
}
