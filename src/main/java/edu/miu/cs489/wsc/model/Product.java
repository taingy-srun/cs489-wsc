package edu.miu.cs489.wsc.model;


import edu.miu.cs489.wsc.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    private String name;
    private Double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Product(String name, Double price, String description, Integer categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = new Category(categoryId, null);
    }

    public Product(Integer productId) {
        this.setProductId(productId);
    }

    public ProductDTO toProductDTO() {
        return new ProductDTO(productId, name, price, description, category.getName());
    }
}
