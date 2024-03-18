package com.example.chargersystem.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class FeeRate {
    private final BigDecimal amount;

    public FeeRate multiply(BigDecimal val) {
        return new FeeRate(amount.multiply(val));
    }

    public long convertToLong() {
        return this.amount.longValueExact();
    }
}
