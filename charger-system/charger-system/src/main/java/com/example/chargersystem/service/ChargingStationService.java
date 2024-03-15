package com.example.chargersystem.service;

import com.example.chargersystem.domain.ChargingStation;
import com.example.chargersystem.domain.ChargingStationRepository;
import com.example.chargersystem.domain.FeeRate;
import com.example.chargersystem.service.dto.AddStationDto;
import com.example.chargersystem.service.dto.StationResponse;
import com.example.chargersystem.service.dto.UpdateStationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ChargingStationService {

    private final ChargingStationRepository chargingStationRepository;

    @Transactional
    public Long addStation(AddStationDto addStationDto) {
        FeeRate feeRate = new FeeRate(new BigDecimal(addStationDto.getFeeRate()));
        ChargingStation chargingStation = new ChargingStation(null, addStationDto.getAddress(), addStationDto.getName(), feeRate);
        return chargingStationRepository.save(chargingStation).getId();
    }

    @Transactional
    public void updateStation(UpdateStationDto updateStationDto) {
        ChargingStation chargingStation = chargingStationRepository.findById(updateStationDto.getId())
                .orElseThrow();
        chargingStation.setName(updateStationDto.getName());
        chargingStation.setAddress(updateStationDto.getAddress());
        FeeRate feeRate = new FeeRate(new BigDecimal(updateStationDto.getFeeRate()));
        chargingStation.setFeeRate(feeRate);
    }

    @Transactional(readOnly = true)
    public StationResponse findById(Long id) {
        ChargingStation chargingStation = chargingStationRepository.findById(id)
                .orElseThrow();
        return new StationResponse(chargingStation.getId(), chargingStation.getName(),
                chargingStation.getAddress(), chargingStation.getFeeRate().toString());
    }
}
