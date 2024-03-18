package com.example.chargersystem.application;

import com.example.chargersystem.adapter.out.persistence.entity.ChargingStationEntity;
import com.example.chargersystem.adapter.out.persistence.entity.EmbeddableFeeRate;
import com.example.chargersystem.adapter.in.web.dto.UpdateStationDto;
import com.example.chargersystem.application.command.UpdateStationCommand;
import com.example.chargersystem.application.port.in.UpdateStationUseCase;
import com.example.chargersystem.application.port.out.UpdateStationPort;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.ICommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateStationService implements UpdateStationUseCase{

    private final UpdateStationPort updateStationPort;

    @Override
    public void update(UpdateStationCommand command) {
        updateStationPort.update(command);
    }
}
