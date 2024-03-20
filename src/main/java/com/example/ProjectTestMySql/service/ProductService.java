package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.mapper.ProductMapper;
import com.example.ProjectTestMySql.model.dto.ProductPayload;
import com.example.ProjectTestMySql.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductService {

    ProductMapper productMapper = ProductMapper.INSTANCE;

    ProductRepository productRepository;

    public ProductPayload saveProduct(ProductPayload productPayload) {
        var product = productMapper.toProduct(productPayload);
        productRepository.save(product);
        return productMapper.toProductPayload(product);
    }
}
