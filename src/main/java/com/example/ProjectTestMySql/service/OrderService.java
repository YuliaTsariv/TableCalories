package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.mapper.OrderMapper;
import com.example.ProjectTestMySql.model.dto.OrderPayload;
import com.example.ProjectTestMySql.model.dto.SearchOrderRequest;
import com.example.ProjectTestMySql.model.dto.SearchOrderResult;
import com.example.ProjectTestMySql.model.entity.Order;
import com.example.ProjectTestMySql.repository.OrderRepository;
import com.example.ProjectTestMySql.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderService {

    OrderMapper orderMapper = OrderMapper.INSTANCE;
    OrderRepository orderRepository;
    ProductRepository productRepository;


    public void saveOder(OrderPayload orderPayload) {
        var product = productRepository.findById(orderPayload.getProductId());
        var order = orderMapper.toOrder(orderPayload);
        order.setProduct(product.orElseThrow());
        orderRepository.save(order);
    }

    public List<SearchOrderResult> searchOrder(SearchOrderRequest request) {
        var dateTime = request.getSearchDateTime();
        var orders = orderRepository.findAllByUserIdAndDateTimeBetween(request.getUserId(),dateTime, dateTime.plusDays(1));
        var searchResult = orders.stream().map(order->orderMapper.toSearchOrderResult(order, 3L)).toList();
        return searchResult;
    }

    @Transactional
    public void partialUpdateOrderConfig(OrderPayload orderPayload) {

        var order = orderRepository.getReferenceById(orderPayload.getId());
        OrderMapper.INSTANCE.updateOrderConfig(orderPayload, order);
    }


    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
