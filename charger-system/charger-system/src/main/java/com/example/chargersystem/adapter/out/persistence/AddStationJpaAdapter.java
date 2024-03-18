package com.example.chargersystem.adapter.out.persistence;

import com.example.chargersystem.adapter.out.persistence.repository.StationJpaRepository;
import com.example.chargersystem.adapter.out.persistence.entity.ChargingStationEntity;
import com.example.chargersystem.adapter.out.persistence.entity.EmbeddableFeeRate;
import com.example.chargersystem.application.port.out.AddChargingStationPort;
import com.example.chargersystem.domain.ChargingStation;
import com.example.chargersystem.domain.FeeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddStationJpaAdapter implements AddChargingStationPort {

    private final StationJpaRepository jpaRepository;

    @Override
    public ChargingStation save(ChargingStation chargingStation) {
        FeeRate feeRate = chargingStation.getFeeRate();
        EmbeddableFeeRate embeddableFeeRate = new EmbeddableFeeRate(feeRate.getAmount());

        ChargingStationEntity entity = new ChargingStationEntity(
                null,
                chargingStation.getAddress(),
                chargingStation.getName(),
                embeddableFeeRate
        );

        jpaRepository.save(entity);

        return new ChargingStation(
                entity.getId(),
                entity.getAddress(),
                entity.getName(),
                feeRate
        );
    }
}
