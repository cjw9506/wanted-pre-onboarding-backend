package com.wantedpreonboardingbackend.domain.company.exception;

import com.wantedpreonboardingbackend.global.exception.GlobalException;

public class CompanyNotFound extends GlobalException {

    private static final String MESSAGE = "해당 회사를 찾을 수 없습니다.";

    public CompanyNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
