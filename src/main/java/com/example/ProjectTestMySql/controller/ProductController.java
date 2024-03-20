package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.service.ProductService;
import com.example.ProjectTestMySql.model.dto.AddMealRequest;
import com.example.ProjectTestMySql.model.dto.ProductPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ProductController.API)
@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    public static final String API = "/api/table/calories";
    public static final String ADD_MEAL = "/add/meal";
    public static final String SAVE_PRODUCT = "/save/product";
    private final ProductService productService;

    @CrossOrigin(originPatterns = "*")
    @PostMapping(ADD_MEAL)
    public ResponseEntity<String> addMeal(@RequestBody AddMealRequest request) {
        log.info("Handle adding meal " + request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(originPatterns = "*")
    @PostMapping(SAVE_PRODUCT)
    public ResponseEntity<ProductPayload> saveProduct(@RequestBody ProductPayload request) {
        log.info("Handle adding meal " + request);

        return ResponseEntity.ok(productService.saveProduct(request));
    }
}
