package com.example.chargersystem.application.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
public class AddStationCommand {
    private final String name;
    private final String address;
    private final String feeRate;

    public AddStationCommand(String name, String address, String feeRate) {
        CommandUtil.throwIfNullOrBlank(name, "name is null or blank.");
        CommandUtil.throwIfNullOrBlank(address, "address is null or blank");
        CommandUtil.throwIfNullOrBlank(feeRate, "feeRate is null or blank");
        this.name = name;
        this.address = address;
        this.feeRate = feeRate;
    }
}
