package edu.miu.cs489.wsc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Integer shoppingCartId;
    private Double price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    public ShoppingCart(Integer productId, Double price, Integer quantity, Integer customerId) {
        this.price = price;
        this.quantity = quantity;
        this.product = new Product(productId);
        this.customer = new Customer(customerId);
    }
}
