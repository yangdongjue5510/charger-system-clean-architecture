package com.example.chargersystem.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddStationDto {
   private final String name;
   private final String address;
   private final String feeRate;
}
