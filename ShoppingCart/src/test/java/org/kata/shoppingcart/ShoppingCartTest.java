package org.kata.shoppingcart;

import org.junit.jupiter.api.Test;
import org.kata.shoppingcart.model.Cart;
import org.kata.shoppingcart.model.Discount;
import org.kata.shoppingcart.model.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    @Test
    void shouldAddProductToShoppingCart_whenAddProductToShoppingCart() {
        ShoppingCartInterface shoppingCart = new ShoppingCart();

        Product iceberg = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product tomate = new Product("Tomate", BigDecimal.valueOf(0.52), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product chicken = new Product("Chicken", BigDecimal.valueOf(1.34), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.21));
        Product bread = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product corn = new Product("Corn", BigDecimal.valueOf(1.21), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));

        Cart cart = shoppingCart.getShoppingCart();
        assertEquals(0, cart.getProducts().size());

        shoppingCart.addProduct(iceberg);
        shoppingCart.addProduct(tomate);
        shoppingCart.addProduct(chicken);
        shoppingCart.addProduct(bread);
        shoppingCart.addProduct(corn);

        cart = shoppingCart.getShoppingCart();
        assertEquals(5, cart.getProducts().size());
        assertEquals(BigDecimal.valueOf(7.11), cart.getTotalPrice());
    }

    @Test
    void shouldAddProductToShoppingCart_whenAddProductToShoppingCartWitDuplicates() {
        ShoppingCartInterface shoppingCart = new ShoppingCart();

        Product iceberg1 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product iceberg2 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product iceberg3 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product tomate = new Product("Tomate", BigDecimal.valueOf(0.52), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product chicken = new Product("Chicken", BigDecimal.valueOf(1.34), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.21));
        Product bread1 = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product bread2 = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product corn = new Product("Corn", BigDecimal.valueOf(1.21), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));

        Cart cart = shoppingCart.getShoppingCart();
        assertEquals(0, cart.getProducts().size());

        shoppingCart.addProduct(iceberg1);
        shoppingCart.addProduct(iceberg2);
        shoppingCart.addProduct(iceberg3);
        shoppingCart.addProduct(tomate);
        shoppingCart.addProduct(chicken);
        shoppingCart.addProduct(bread1);
        shoppingCart.addProduct(bread2);
        shoppingCart.addProduct(corn);

        cart = shoppingCart.getShoppingCart();
        assertEquals(8, cart.getProducts().size());
        assertEquals(BigDecimal.valueOf(12.33), cart.getTotalPrice());
    }

    @Test
    void shouldAddProductToShoppingCartWithDiscount_whenAddProductToShoppingCartWitDuplicatesAndDiscount5() {
        ShoppingCartInterface shoppingCart = new ShoppingCart();

        Product iceberg1 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product iceberg2 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product iceberg3 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product tomate = new Product("Tomate", BigDecimal.valueOf(0.52), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product chicken = new Product("Chicken", BigDecimal.valueOf(1.34), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.21));
        Product bread1 = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product bread2 = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product corn = new Product("Corn", BigDecimal.valueOf(1.21), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));

        Cart cart = shoppingCart.getShoppingCart();
        assertEquals(0, cart.getProducts().size());

        shoppingCart.addProduct(iceberg1);
        shoppingCart.addProduct(iceberg2);
        shoppingCart.addProduct(iceberg3);
        shoppingCart.addProduct(tomate);
        shoppingCart.addProduct(chicken);
        shoppingCart.addProduct(bread1);
        shoppingCart.addProduct(bread2);
        shoppingCart.addProduct(corn);

        shoppingCart.applyDiscount(Discount.PROMO_5);

        cart = shoppingCart.getShoppingCart();
        assertEquals(8, cart.getProducts().size());
        assertEquals(BigDecimal.valueOf(11.71), cart.getTotalPrice());
    }

    @Test
    void shouldAddProductToShoppingCartWithDiscount_whenAddProductToShoppingCartWitDuplicatesAndDiscount10() {
        ShoppingCartInterface shoppingCart = new ShoppingCart();

        Product iceberg1 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product iceberg2 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product iceberg3 = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product tomate = new Product("Tomate", BigDecimal.valueOf(0.52), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product chicken = new Product("Chicken", BigDecimal.valueOf(1.34), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.21));
        Product bread1 = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product bread2 = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product corn = new Product("Corn", BigDecimal.valueOf(1.21), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));

        Cart cart = shoppingCart.getShoppingCart();
        assertEquals(0, cart.getProducts().size());

        shoppingCart.addProduct(iceberg1);
        shoppingCart.addProduct(iceberg2);
        shoppingCart.addProduct(iceberg3);
        shoppingCart.addProduct(tomate);
        shoppingCart.addProduct(chicken);
        shoppingCart.addProduct(bread1);
        shoppingCart.addProduct(bread2);
        shoppingCart.addProduct(corn);

        shoppingCart.applyDiscount(Discount.PROMO_10);

        cart = shoppingCart.getShoppingCart();
        assertEquals(8, cart.getProducts().size());
        assertEquals(BigDecimal.valueOf(11.10).setScale(2), cart.getTotalPrice());
    }

    @Test
    void shouldCalculateProperPrice_whenAddProductsToShoppingCartAndDeleteProduct() {
        ShoppingCartInterface shoppingCart = new ShoppingCart();

        Product iceberg = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product tomate = new Product("Tomate", BigDecimal.valueOf(0.52), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product chicken = new Product("Chicken", BigDecimal.valueOf(1.34), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.21));
        Product bread = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product corn = new Product("Corn", BigDecimal.valueOf(1.21), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));

        Cart cart = shoppingCart.getShoppingCart();
        assertEquals(0, cart.getProducts().size());

        shoppingCart.addProduct(iceberg);
        shoppingCart.addProduct(tomate);
        shoppingCart.addProduct(chicken);
        shoppingCart.addProduct(bread);
        shoppingCart.addProduct(corn);

        cart = shoppingCart.getShoppingCart();
        assertEquals(5, cart.getProducts().size());
        assertEquals(BigDecimal.valueOf(7.11), cart.getTotalPrice());

        shoppingCart.deleteProduct(iceberg);

        cart = shoppingCart.getShoppingCart();
        assertEquals(4, cart.getProducts().size());
        assertEquals(BigDecimal.valueOf(4.94), cart.getTotalPrice());
    }

    @Test
    void shouldReturnEmptyCart_whenAddProductsToShoppingCartAndDeleteThem() {
        ShoppingCartInterface shoppingCart = new ShoppingCart();

        Product iceberg = new Product("Iceberg", BigDecimal.valueOf(1.55), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product tomate = new Product("Tomate", BigDecimal.valueOf(0.52), BigDecimal.valueOf(1.15), BigDecimal.valueOf(1.21));
        Product chicken = new Product("Chicken", BigDecimal.valueOf(1.34), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.21));
        Product bread = new Product("Bread", BigDecimal.valueOf(0.71), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));
        Product corn = new Product("Corn", BigDecimal.valueOf(1.21), BigDecimal.valueOf(1.12), BigDecimal.valueOf(1.10));

        Cart cart = shoppingCart.getShoppingCart();
        assertEquals(0, cart.getProducts().size());

        shoppingCart.addProduct(iceberg);
        shoppingCart.addProduct(tomate);
        shoppingCart.addProduct(chicken);
        shoppingCart.addProduct(bread);
        shoppingCart.addProduct(corn);

        cart = shoppingCart.getShoppingCart();
        assertEquals(5, cart.getProducts().size());
        assertEquals(BigDecimal.valueOf(7.11), cart.getTotalPrice());

        shoppingCart.deleteProduct(iceberg);
        shoppingCart.deleteProduct(tomate);
        shoppingCart.deleteProduct(chicken);
        shoppingCart.deleteProduct(bread);
        shoppingCart.deleteProduct(corn);

        cart = shoppingCart.getShoppingCart();
        assertEquals(0, cart.getProducts().size());
        assertEquals(BigDecimal.valueOf(0).setScale(2), cart.getTotalPrice());
    }
}
