package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.domains.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(orderDto.getUser());
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser(),
                order.getProducts());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(o -> new OrderDto(o.getId(), o.getUser(), o.getProducts()))
                .collect(Collectors.toList());
    }
}
