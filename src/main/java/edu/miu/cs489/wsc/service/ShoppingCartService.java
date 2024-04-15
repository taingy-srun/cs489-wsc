package edu.miu.cs489.wsc.service;

import edu.miu.cs489.wsc.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCart> getAllByCustomerId(Integer customerId);
}
