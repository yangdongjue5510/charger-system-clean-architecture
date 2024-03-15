package com.example.chargersystem.domain;

import jakarta.persistence.*;

@Entity
public class Charger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ChargerStatus status;

    @ManyToOne
    @JoinColumn(name = "charging_station_id")
    private ChargingStation station;
}
