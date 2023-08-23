package org.kata.shoppingcart;

import org.kata.shoppingcart.model.Cart;
import org.kata.shoppingcart.model.Discount;
import org.kata.shoppingcart.model.Product;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart implements ShoppingCartInterface {

    private final Cart cart;

    public ShoppingCart() {
        this.cart = new Cart();
    }

    @Override
    public void addProduct(Product product) {
        cart.addProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        cart.removeProduct(product);
    }

    @Override
    public Cart getShoppingCart() {
        printCart();
        return cart;
    }

    @Override
    public void applyDiscount(Discount discount) {
        this.cart.setDiscount(discount);
    }

    private void printPromotion() {
        if (cart.getDiscount() != null) {
            System.out.println("Promotion: " + getPromotionValue() + "% off with code " + cart.getDiscount().getCode());
        } else {
            System.out.println("Promotion: ");
        }
    }

    private BigDecimal getPromotionValue() {
        return BigDecimal.valueOf(1).subtract(cart.getDiscount().getAmount()).abs().multiply(BigDecimal.valueOf(100)).setScale(0);
    }

    private BigDecimal getProductCost(Map.Entry<String, Long> entry) {
        return cart.getProducts()
                .stream()
                .filter(product -> product.getName().equals(entry.getKey()))
                .map(Product::getCost)
                .findFirst()
                .get();
    }

    private void printCart() {
        Map<String, Long> collect = cart.getProducts()
                .stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
        System.out.println("Product name\t| Price with VAT\t| Quantity");
        for (Map.Entry<String, Long> entry : collect.entrySet()) {
            System.out.println(String.format("%s\t| %.2f$\t| %d", entry.getKey(), getProductCost(entry), entry.getValue()));
        }
        printPromotion();
        System.out.println(String.format("Total products: %d", collect.values().stream().collect(Collectors.summarizingLong(Long::longValue)).getSum()));
        System.out.println(String.format("Total price: %.2f$", cart.getTotalPrice()));
        System.out.println("************************************************************");
    }
}
