package com.example.chargersystem.application.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class UpdateStationCommand {
    private final Long id;
    private final String name;
    private final String address;
    private final String feeRate;

    public UpdateStationCommand(Long id, String name, String address, String feeRate) {
        CommandUtil.throwIfNull(id, "id is null");
        CommandUtil.throwIfNullOrBlank(name, "name is null or blank");
        CommandUtil.throwIfNullOrBlank(address, "address is null or blank");
        CommandUtil.throwIfNullOrBlank(feeRate, "feeRate is null or blank");
        this.id = id;
        this.name = name;
        this.address = address;
        this.feeRate = feeRate;
    }
}
