package com.example.chargersystem.application.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StationResponse {
    private final Long id;
    private final String name;
    private final String address;
    private final String feeRate;
}
