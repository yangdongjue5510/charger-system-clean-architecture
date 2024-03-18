package com.example.chargersystem.application.port.in;

import com.example.chargersystem.application.response.StationResponse;

public interface QueryStationUseCase {

    StationResponse findById(Long id);
}
