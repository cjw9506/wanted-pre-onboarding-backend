package com.wantedpreonboardingbackend.domain.user.controller;

import com.wantedpreonboardingbackend.domain.user.dto.UserRequest;
import com.wantedpreonboardingbackend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserRequest request) {
        Long userId = userService.register(request);

        return ResponseEntity.created(URI.create("/user/" + userId)).build();
    }
}
