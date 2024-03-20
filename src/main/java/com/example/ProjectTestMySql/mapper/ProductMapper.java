package com.example.ProjectTestMySql.mapper;

import com.example.ProjectTestMySql.entity.Product;
import com.example.ProjectTestMySql.model.dto.ProductPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "nutritionInfo.proteins", source = "proteins")
    @Mapping(target = "nutritionInfo.carbohydrates", source = "carbohydrates")
    @Mapping(target = "nutritionInfo.fats", source = "fats")
    Product toProduct(ProductPayload productPayload);

    @Mapping(source = "nutritionInfo.proteins", target = "proteins")
    @Mapping(source = "nutritionInfo.carbohydrates", target = "carbohydrates")
    @Mapping(source = "nutritionInfo.fats", target = "fats")
    ProductPayload toProductPayload(Product product);
}
