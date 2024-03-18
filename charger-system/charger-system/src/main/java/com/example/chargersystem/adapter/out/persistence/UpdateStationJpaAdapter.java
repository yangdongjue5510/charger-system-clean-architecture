package com.example.chargersystem.adapter.out.persistence;

import com.example.chargersystem.adapter.out.persistence.repository.StationJpaRepository;
import com.example.chargersystem.adapter.out.persistence.entity.ChargingStationEntity;
import com.example.chargersystem.adapter.out.persistence.entity.EmbeddableFeeRate;
import com.example.chargersystem.application.command.UpdateStationCommand;
import com.example.chargersystem.application.port.out.UpdateStationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@RequiredArgsConstructor
public class UpdateStationJpaAdapter implements UpdateStationPort {

    private final StationJpaRepository jpaRepository;


    @Override
    public void update(UpdateStationCommand command) {
        ChargingStationEntity entity = jpaRepository.findById(command.getId())
                .orElseThrow();

        EmbeddableFeeRate embeddableFeeRate = new EmbeddableFeeRate(new BigDecimal(command.getFeeRate()));
        entity.setAddress(command.getAddress());
        entity.setName(command.getName());
        entity.setFeeRate(embeddableFeeRate);
    }
}
