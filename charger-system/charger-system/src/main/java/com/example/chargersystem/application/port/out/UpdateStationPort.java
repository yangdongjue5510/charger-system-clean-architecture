package com.example.chargersystem.application.port.out;

import com.example.chargersystem.application.command.UpdateStationCommand;

public interface UpdateStationPort {
    void update(UpdateStationCommand command);
}
