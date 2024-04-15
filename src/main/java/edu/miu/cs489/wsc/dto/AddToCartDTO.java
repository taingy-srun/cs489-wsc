package edu.miu.cs489.wsc.dto;

import edu.miu.cs489.wsc.model.ShoppingCart;

public record AddToCartDTO(Integer customerId, Integer productId, Double price, Integer quantity) {

    public ShoppingCart toShoppingCart() {
        return new ShoppingCart(productId, price, quantity, customerId);
    }
}
