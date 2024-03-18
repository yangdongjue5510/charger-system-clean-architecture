package com.example.chargersystem.adapter.out.persistence.repository;

import com.example.chargersystem.adapter.out.persistence.entity.ChargingStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationJpaRepository extends JpaRepository<ChargingStationEntity, Long> {
}
