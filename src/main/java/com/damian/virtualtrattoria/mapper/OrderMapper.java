package com.damian.virtualtrattoria.mapper;

import com.damian.virtualtrattoria.entity.OrderEntity;
import com.damian.virtualtrattoria.to.OrderTO;

/**
 * Class of the mapper for orders.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class OrderMapper {

    /**
     * This method creates order entity from TO.
     *
     * @param order given order in TO.
     * @return order in entity form.
     */
    public static OrderEntity mapToEntity(OrderTO order) {
        return OrderEntity.builder().number(order.getNumber())
                .customerFirstName(order.getCustomerFirstName())
                .customerSecondName(order.getCustomerSecondName())
                .customerAddress(order.getCustomerAddress())
                .orderDate(order.getOrderDate())
                .pizzas(PizzaMapper.mapToEntities(order.getPizzas()))
                .amount(order.getAmount()).build();
    }

    /**
     * This method creates order TO from entity.
     *
     * @param order given order in entity.
     * @return order in TO form.
     */
    public static OrderTO mapToTO(OrderEntity order) {
        return OrderTO.builder().number(order.getNumber())
                .customerFirstName(order.getCustomerFirstName())
                .customerSecondName(order.getCustomerSecondName())
                .customerAddress(order.getCustomerAddress())
                .orderDate(order.getOrderDate())
                .pizzas(PizzaMapper.mapToTOs(order.getPizzas()))
                .amount(order.getAmount()).build();
    }

}
