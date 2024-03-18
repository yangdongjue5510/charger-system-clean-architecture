package com.example.chargersystem.application;

import com.example.chargersystem.application.command.AddStationCommand;
import com.example.chargersystem.application.port.in.AddStationUseCase;
import com.example.chargersystem.application.port.out.AddChargingStationPort;
import com.example.chargersystem.domain.ChargingStation;
import com.example.chargersystem.domain.FeeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
public class AddStationService implements AddStationUseCase {

    private final AddChargingStationPort addChargingStationPort;

    @Override
    public Long addStation(AddStationCommand command) {
        FeeRate feeRate = new FeeRate(new BigDecimal(command.getFeeRate()));
        ChargingStation chargingStation = new ChargingStation(
                null,
                command.getAddress(),
                command.getName(),
                feeRate);
        return addChargingStationPort.save(chargingStation).getId();
    }
}
