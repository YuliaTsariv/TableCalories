package com.example.ProjectTestMySql.mapper;

import com.example.ProjectTestMySql.model.dto.OrderPayload;
import com.example.ProjectTestMySql.model.dto.SearchOrderResult;
import com.example.ProjectTestMySql.model.entity.Order;
import com.example.ProjectTestMySql.model.entity.Product;
import com.example.ProjectTestMySql.model.dto.ProductPayload;
import org.mapstruct.*;
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

    SearchOrderResult toSearchOrderResponse(Product product);


    @Mapping(target = "nutritionInfo.proteins", source = "proteins")
    @Mapping(target = "nutritionInfo.carbohydrates", source = "carbohydrates")
    @Mapping(target = "nutritionInfo.fats", source = "fats")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateProductConfig(ProductPayload productPayload, @MappingTarget Product product);
}
