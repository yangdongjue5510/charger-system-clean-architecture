package com.example.chargersystem.application.port.out;

import com.example.chargersystem.application.response.StationResponse;
import com.example.chargersystem.domain.ChargingStation;

public interface QueryStationPort {

    StationResponse findById(Long id);
}
