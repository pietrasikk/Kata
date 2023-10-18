package org.kata.atm;

public class Money {

    private final int value;
    private final int quantity;
    private final Type type;

    public Money(int value, int quantity, Type type) {
        this.value = value;
        this.quantity = quantity;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", quantity=" + quantity +
                ", type=" + type +
                '}';
    }
}
