package edu.miu.cs489.wsc.dto;

import edu.miu.cs489.wsc.model.Product;

public record ProductUpdateDTO(Integer productId, ProductCreationDTO productCreationDTO) {

    public Product toProduct() {
        Product product = productCreationDTO.toProduct();
        product.setProductId(productId);
        return product;
    }
}
