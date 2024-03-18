package com.example.chargersystem.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class ChargingStation {

    private final Long id;

    private final String address;

    private final String name;

    private final FeeRate feeRate;

    public long calculateFeeAmount(BigDecimal chargedAmount) {
        return this.feeRate
                .multiply(chargedAmount)
                .convertToLong();
    }
}
