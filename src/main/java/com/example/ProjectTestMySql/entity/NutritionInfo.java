package com.example.ProjectTestMySql.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "nutrion_info")
public class NutritionInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float proteins;
    private Float fats;
    private Float carbohydrates;

    // Getters and setters
}
