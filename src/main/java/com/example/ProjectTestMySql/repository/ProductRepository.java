package com.example.ProjectTestMySql.repository;

import com.example.ProjectTestMySql.model.entity.Order;
import com.example.ProjectTestMySql.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
