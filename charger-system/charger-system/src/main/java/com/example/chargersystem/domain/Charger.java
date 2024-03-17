package com.example.chargersystem.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Charger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ChargerStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charging_station_id")
    private ChargingStation station;
}
