package com.example.ProjectTestMySql.model.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Builder
@Table(name = "dish")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_weight_id")
    private Integer totalWeight;

    // Getters and setters
}