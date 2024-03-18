package com.example.chargersystem.adapter.in.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateStationDto {
    private final Long id;
    private final String name;
    private final String address;
    private final String feeRate;
}
