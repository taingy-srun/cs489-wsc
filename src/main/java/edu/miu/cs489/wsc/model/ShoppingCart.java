package edu.miu.cs489.wsc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shoppingCartId;

    @OneToMany
    @JoinTable(
            name = "shopping_cart_products",
            joinColumns = {@JoinColumn(name = "shopping_cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> productList;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
}
