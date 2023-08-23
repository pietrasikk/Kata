package org.kata.shoppingcart.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private final String name;
    private final BigDecimal cost;
    private final BigDecimal revenue;
    private final BigDecimal tax;

    public Product(String name, BigDecimal cost, BigDecimal revenue, BigDecimal tax) {
        this.name = name;
        this.cost = cost;
        this.revenue = revenue;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getTax() {
        return tax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(cost, product.cost) && Objects.equals(revenue, product.revenue) && Objects.equals(tax, product.tax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, revenue, tax);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", revenue=" + revenue +
                ", tax=" + tax +
                '}';
    }
}
