package com.example.chargersystem.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.math.BigDecimal;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeeRate {
    private BigDecimal amount;

    public FeeRate multiply(BigDecimal val) {
        return new FeeRate(amount.multiply(val));
    }

    public long convertToLong() {
        return this.amount.longValueExact();
    }

    @Override
    public String toString() {
        return amount.toString();
    }
}
