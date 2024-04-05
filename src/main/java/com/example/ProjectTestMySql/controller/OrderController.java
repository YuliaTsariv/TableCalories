package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.model.dto.OrderPayload;
import com.example.ProjectTestMySql.model.dto.SearchOrderRequest;
import com.example.ProjectTestMySql.model.dto.SearchOrderResult;
import com.example.ProjectTestMySql.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequestMapping(ProductController.API)
@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    public static final String ORDER = "/order";
    private final OrderService orderService;


    @CrossOrigin(originPatterns = "*")
    @PostMapping(ORDER)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderPayload orderPayload) {
        log.info("Handle adding order " + orderPayload);
        orderService.saveOder(orderPayload);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping(ORDER)
    public ResponseEntity<List<SearchOrderResult>> searchOrderByParam(@RequestParam SearchOrderRequest request) {
        log.info("Handle searching order: " + request);

        return ResponseEntity.ok(orderService.searchOrder(request));
    }

    @CrossOrigin(originPatterns = "*")
    @PatchMapping(ORDER)
    public ResponseEntity<Void> partialUpdateOrderConfig(@RequestBody OrderPayload orderPayload) {
        log.info("Handle update order: " + orderPayload);
        orderService.partialUpdateOrderConfig(orderPayload);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @CrossOrigin(originPatterns = "*")
    @DeleteMapping(ORDER)
    public ResponseEntity<Void> deleteOrder(@RequestParam Long id) {
        log.info("Handle deleting order with id: " + id);
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
