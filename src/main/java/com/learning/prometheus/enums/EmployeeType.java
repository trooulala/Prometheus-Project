package com.learning.prometheus.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmployeeType {
    ADMINISTRATOR("ADM"),
    PROGRAMMER("PRG"),
    RECRUITER("REC"),
    SALESMAN("SAL");

    private final String code;
}
