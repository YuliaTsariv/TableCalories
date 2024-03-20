package com.example.ProjectTestMySql.model.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "component_of_dish")
public class ComponentOfDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_weight")
    private Double productWeight;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    // Getters and setters
}