package com.example.ProjectTestMySql.mapper;

import com.example.ProjectTestMySql.model.dto.OrderPayload;
import com.example.ProjectTestMySql.model.dto.SearchOrderResult;
import com.example.ProjectTestMySql.model.entity.Order;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderPayload orderPayload);

    OrderPayload toOrderPayload(Order order);


    @Mapping(source = "order.product.name", target = "name")
    @Mapping(source = "calories", target = "calories")
    SearchOrderResult toSearchOrderResult(Order order, Long calories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateOrderConfig(OrderPayload orderPayload, @MappingTarget Order order);
}
