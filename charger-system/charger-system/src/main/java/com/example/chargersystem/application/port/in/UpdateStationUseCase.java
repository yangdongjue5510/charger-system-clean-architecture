package com.example.chargersystem.application.port.in;

import com.example.chargersystem.application.command.UpdateStationCommand;

public interface UpdateStationUseCase {

    void update(UpdateStationCommand command);
}
