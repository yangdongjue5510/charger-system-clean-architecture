package com.example.chargersystem.adapter.out.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.math.BigDecimal;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmbeddableFeeRate {

    private BigDecimal amount;

    public String toNumericString() {
        return amount.toPlainString();
    }
}
