package com.damian.virtualtrattoria.service;

import com.damian.virtualtrattoria.to.OrderTO;
import com.damian.virtualtrattoria.to.PizzaTO;

import java.util.List;

/**
 * Interface contains method creating from given string values entities of the product.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public interface OrderService {

    /**
     * Method takes information about order and creates order TO with first and second name,
     * address and pizzas of the client.
     *
     * @param firstName  name of the client.
     * @param secondName surname of the client.
     * @param address    address of the client.
     * @param pizzas     ordered by client.
     * @return order with created data - number and date.
     */
    OrderTO createOrder(String firstName, String secondName, String address, List<PizzaTO> pizzas);

}
