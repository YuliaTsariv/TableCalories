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
    public static final String PRODUCT = "/product";

    private final ProductService productService;

    @CrossOrigin(originPatterns = "*")
    @PostMapping(PRODUCT)
    public ResponseEntity<ProductPayload> saveProduct(@RequestBody ProductPayload request) {
        log.info("Handle adding meal " + request);

        return ResponseEntity.ok(productService.saveProduct(request));
    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping(PRODUCT)
    public ResponseEntity<ProductPayload> getProductDetails(@RequestParam Long id) {
        log.info("Handle getting info about product with id: " + id);

        return ResponseEntity.ok(productService.getProduct(id));
    }

    @CrossOrigin(originPatterns = "*")
    @PatchMapping(PRODUCT)
    public ResponseEntity<Void> updateProduct(@RequestBody ProductPayload request) {
        log.info("Handle updating product: " + request);
        productService.updateProduct(request);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(originPatterns = "*")
    @DeleteMapping(PRODUCT)
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
        log.info("Handle deleting product with id: " + id);
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
