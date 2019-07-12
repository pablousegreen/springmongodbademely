package com.springmongodbademely.enums;

import java.math.BigDecimal;

public enum TransactionTypeOperation {

    IN,

    OUT;

    public BigDecimal calculateBalanceWithAmount(final BigDecimal balance, final BigDecimal amount) {
        switch (this) {
        case OUT:
            return balance.subtract(amount);
        case IN:
            return balance.add(amount);
        default:
            throw new IllegalArgumentException("Undefined operation for this Enum: " + this.name());
        }
    };

}
