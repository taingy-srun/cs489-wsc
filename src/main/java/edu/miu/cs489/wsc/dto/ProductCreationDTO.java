package edu.miu.cs489.wsc.dto;

import edu.miu.cs489.wsc.model.Product;

public record ProductCreationDTO(String productName, Double price, String description, Integer categoryId) {

    public Product toProduct() {
        return new Product(productName, price, description, categoryId);
    }
}
