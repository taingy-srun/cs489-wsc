package edu.miu.cs489.wsc.service.impl;

import edu.miu.cs489.wsc.model.ShoppingCart;
import edu.miu.cs489.wsc.repository.ShoppingCartRepository;
import edu.miu.cs489.wsc.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartRepository repository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingCart getByCustomerId(Integer customerId) {
        return null;
    }
}
