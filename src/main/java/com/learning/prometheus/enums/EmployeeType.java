package com.learning.prometheus.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EmployeeType {
    PROGRAMMER("PRG"),
    RECRUITER("REC"),
    SALESMAN("SAL");

    private final String code;
}
