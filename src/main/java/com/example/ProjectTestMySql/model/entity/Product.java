package com.example.ProjectTestMySql.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer calories;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrition_info_id")
    private NutritionInfo nutritionInfo;
}
