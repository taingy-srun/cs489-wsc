package edu.miu.cs489.wsc.service;

import edu.miu.cs489.wsc.model.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart getByCustomerId(Integer customerId);
}
