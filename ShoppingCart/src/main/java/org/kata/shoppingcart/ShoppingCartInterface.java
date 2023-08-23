package org.kata.shoppingcart;

import org.kata.shoppingcart.model.Cart;
import org.kata.shoppingcart.model.Discount;
import org.kata.shoppingcart.model.Product;

public interface ShoppingCartInterface {

    void addProduct(Product product);

    void deleteProduct(Product product);

    void applyDiscount(Discount discount);

    Cart getShoppingCart();
}
