package com.example.chargersystem.application.port.in;

import com.example.chargersystem.application.command.AddStationCommand;

public interface AddStationUseCase {
    Long addStation(AddStationCommand command);
}
