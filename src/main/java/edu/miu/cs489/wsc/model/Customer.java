package edu.miu.cs489.wsc.model;

import edu.miu.cs489.wsc.dto.CustomerDTO;
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
    @JoinTable(
            name = "product_reviews",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_review_id")}
    )
    private List<ProductReview> reviewedProduct;

    @OneToMany
    @JoinTable(
            name = "customer_shopping_carts",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "shopping_cart_id")}
    )
    private List<ShoppingCart> shoppingCarts;

    public Customer(String firstname, String lastname, String phone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public CustomerDTO toCustomerDTO() {
        return new CustomerDTO(customerId, firstname, lastname, phone, email);
    }
}
