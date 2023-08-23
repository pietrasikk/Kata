package org.kata.shoppingcart.model;

import java.math.BigDecimal;

public enum Discount {
    PROMO_5("PROMO_5", BigDecimal.valueOf(0.95)),
    PROMO_10("PROMO_10", BigDecimal.valueOf(0.90));

    private final String code;
    private final BigDecimal amount;

    Discount(String code, BigDecimal amount) {
        this.code = code;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCode() {
        return code;
    }
}
