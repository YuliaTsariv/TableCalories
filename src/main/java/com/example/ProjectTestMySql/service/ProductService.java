package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.mapper.ProductMapper;
import com.example.ProjectTestMySql.model.dto.ProductPayload;
import com.example.ProjectTestMySql.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ProductPayload getProduct(Long id) {
        var product = productRepository.findById(id).orElseThrow();
        return productMapper.toProductPayload(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(ProductPayload productPayload) {
        var product = productRepository.findById(productPayload.getId()).orElseThrow();
        productMapper.updateProductConfig(productPayload, product);
    }
}
