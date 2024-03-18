package com.example.chargersystem.adapter.out.persistence.repository;

import com.example.chargersystem.adapter.out.persistence.entity.ChargerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargerJpaRepository extends JpaRepository<ChargerEntity, Long> {
}
