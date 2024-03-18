package com.example.chargersystem.adapter.in.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddStationDto {
   private final String name;
   private final String address;
   private final String feeRate;
}
