package edu.miu.cs489.wsc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    @OneToMany
    private List<Product> reviewedProduct;

    @OneToMany
    private List<ShoppingCart> shoppingCarts;
}
