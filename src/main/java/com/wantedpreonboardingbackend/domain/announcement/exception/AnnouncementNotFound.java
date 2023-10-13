package com.wantedpreonboardingbackend.domain.announcement.exception;

import com.wantedpreonboardingbackend.global.exception.GlobalException;

public class AnnouncementNotFound extends GlobalException {

    private static final String MESSAGE = "해당 채용공고를 찾을 수 없습니다.";

    public AnnouncementNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
