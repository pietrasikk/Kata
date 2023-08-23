package org.kata.shoppingcart.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Product> products;
    private Discount discount;
    private BigDecimal totalPrice;

    public Cart() {
        this.products = new ArrayList<>();
        this.totalPrice = BigDecimal.ZERO;
    }

    public void addProduct(Product product) {
        products.add(product);
        calculateTotalPrice(product);
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) this.products.remove(product);
        BigDecimal productCost = product.getCost()
                .multiply(product.getRevenue()).setScale(2, RoundingMode.UP)
                .multiply(product.getTax()).setScale(2, RoundingMode.UP);
        totalPrice = totalPrice.subtract(productCost);
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
        calculateDiscount(discount);
    }

    public Discount getDiscount() {
        return discount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProducts() {
        if (products.isEmpty()) return List.of();
        else return List.copyOf(products);
    }

    private void calculateTotalPrice(Product product) {
        totalPrice = product.getCost()
                .multiply(product.getRevenue()).setScale(2, RoundingMode.UP)
                .multiply(product.getTax()).setScale(2, RoundingMode.UP)
                .add(totalPrice);
    }

    private void calculateDiscount(Discount discount) {
        totalPrice = totalPrice.multiply(discount.getAmount(), new MathContext(4));
    }
}
