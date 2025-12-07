package com.learning.prometheus.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum InventoryType {
    NOTEBOOK("NBK"),
    MOBILE_PHONE("MPH"),
    TABLET("TBL");

    private final String code;
}
