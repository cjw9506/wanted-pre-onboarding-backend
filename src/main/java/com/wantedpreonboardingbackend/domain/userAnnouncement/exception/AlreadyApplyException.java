package com.wantedpreonboardingbackend.domain.userAnnouncement.exception;

import com.wantedpreonboardingbackend.global.exception.GlobalException;

public class AlreadyApplyException extends GlobalException {

    private static final String MESSAGE = "이미 지원한 공고입니다.";

    public AlreadyApplyException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 403;
    }
}
