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
@Table(name = "order_lines")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    private Integer orderLineId;
    private Integer quantity;
    private Double price;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
