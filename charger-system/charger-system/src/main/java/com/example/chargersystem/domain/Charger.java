package com.example.chargersystem.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Charger {

    private final Long id;

    private final String name;

    private final ChargerStatus status;

    private final ChargingStation station;
}
