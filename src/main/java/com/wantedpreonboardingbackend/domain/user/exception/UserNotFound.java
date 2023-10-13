package com.wantedpreonboardingbackend.domain.user.exception;

import com.wantedpreonboardingbackend.global.exception.GlobalException;

public class UserNotFound extends GlobalException {

    private static final String MESSAGE = "유저를 찾을 수 없습니다.";

    public UserNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
