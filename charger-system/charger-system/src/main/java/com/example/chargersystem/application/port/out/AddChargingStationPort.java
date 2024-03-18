package com.example.chargersystem.application.port.out;

import com.example.chargersystem.domain.ChargingStation;

public interface AddChargingStationPort {

    ChargingStation save(ChargingStation chargingStation);
}
