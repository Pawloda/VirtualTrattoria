package com.damian.virtualtrattoria.repository;

import com.damian.virtualtrattoria.entity.OrderEntity;

public interface OrderRepository {

    /**
     * Methods takes order with given name, surname, address of the client and pizzas. It counts list of previous
     * orders and gives the number to the order and date.
     *
     * @param order given order with customer's first name, second name and address.
     * @return order with given extra date and number.
     */
    OrderEntity createOrder(OrderEntity order);

}
