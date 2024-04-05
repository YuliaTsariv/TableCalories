package com.example.ProjectTestMySql.repository;

import com.example.ProjectTestMySql.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserIdAndDateTimeBetween(Long userId, OffsetDateTime startDate, OffsetDateTime endDate);
}
