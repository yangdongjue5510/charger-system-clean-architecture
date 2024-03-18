package com.example.chargersystem.adapter.out.persistence;

import com.example.chargersystem.adapter.out.persistence.repository.StationJpaRepository;
import com.example.chargersystem.adapter.out.persistence.entity.ChargingStationEntity;
import com.example.chargersystem.application.port.out.QueryStationPort;
import com.example.chargersystem.application.response.StationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QueryStationJpaAdapter implements QueryStationPort {

    private final StationJpaRepository jpaRepository;

    @Override
    public StationResponse findById(Long id) {
        ChargingStationEntity entity = jpaRepository.findById(id)
                .orElseThrow();
        return new StationResponse(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getFeeRate().toNumericString()
        );
    }
}
