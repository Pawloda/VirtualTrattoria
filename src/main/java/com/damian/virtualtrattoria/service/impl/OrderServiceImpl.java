package com.damian.virtualtrattoria.service.impl;

import com.damian.virtualtrattoria.entity.OrderEntity;
import com.damian.virtualtrattoria.mapper.OrderMapper;
import com.damian.virtualtrattoria.repository.OrderRepository;
import com.damian.virtualtrattoria.repository.impl.OrderRepositoryImpl;
import com.damian.virtualtrattoria.service.OrderService;
import com.damian.virtualtrattoria.to.OrderTO;
import com.damian.virtualtrattoria.to.PizzaTO;

import java.util.List;

/**
 * Class implements interface of order's service.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class OrderServiceImpl implements OrderService {

    protected OrderRepository orderRepository = new OrderRepositoryImpl();

    /**
     * Method creates new order object with full name, address of customer and list of pizzas.
     * Then it calls repository and take from it saved order with number and date.
     *
     * @param firstName  name of the client.
     * @param secondName surname of the client.
     * @param address    address of the client.
     * @param pizzas     ordered by client.
     * @return order in TO form.
     */
    @Override
    public OrderTO createOrder(String firstName, String secondName, String address, List<PizzaTO> pizzas) {
        OrderTO order = OrderTO.builder()
                .customerFirstName(firstName)
                .customerSecondName(secondName)
                .customerAddress(address)
                .pizzas(pizzas)
                .amount(countAmountForPizzas(pizzas))
                .build();
        return OrderMapper.mapToTO(createOrderInRepository(order));
    }

    /**
     * Method calls repository and creates in it new order with given values.
     *
     * @param order given order with name, surname, address and pizzas.
     * @return
     */
    protected OrderEntity createOrderInRepository(OrderTO order) {
        return orderRepository.createOrder(OrderMapper.mapToEntity(order));
    }

    /**
     * Method takes full price of every pizza in order and count the sum.
     *
     * @return summary amount.
     */
    private double countAmountForPizzas(List<PizzaTO> pizzas) {
        double amount = 0d;
        for(PizzaTO pizza : pizzas) {
            amount += pizza.getFullPizzaWithIngredientsPrice();
        }
        return amount;
    }

}
