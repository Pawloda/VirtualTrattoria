package com.damian.virtualtrattoria.service;

import com.damian.virtualtrattoria.entity.OrderEntity;
import com.damian.virtualtrattoria.entity.PizzaEntity;
import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;
import com.damian.virtualtrattoria.mapper.PizzaMapper;
import com.damian.virtualtrattoria.service.impl.OrderServiceImpl;
import com.damian.virtualtrattoria.to.OrderTO;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class with tests for order's service.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
@Suite
@SuiteDisplayName("Input Order Service's Test")
public class OrderServiceTest {

    private final PizzaEntity pizza1 = PizzaEntity.builder().pizzaName(PizzaName.MARGHERITA)
            .extraIngredients(List.of(Ingredient.CHEESE)).build();
    private final PizzaEntity pizza2 = PizzaEntity.builder().pizzaName(PizzaName.CALZONE)
            .extraIngredients(List.of(Ingredient.CHEESE)).build();

    private final String firstName = "firstName";
    private final String secondName = "secondName";
    private final String address = "address";
    private final long number = 11L;
    private final LocalDateTime date = LocalDateTime.of(2000, 1, 1, 1, 1);

    private final OrderEntity order1 = OrderEntity.builder().customerFirstName(firstName).customerSecondName(secondName)
            .customerAddress(address).pizzas(List.of(pizza1, pizza2)).number(number)
            .orderDate(date).build();

    /**
     * Inner class overrides method in order's service.
     *
     * @author Damian
     * @version 1.0
     * @since 05.01.2022
     */
    private final class OrderServiceMock extends OrderServiceImpl {

        @Override
        protected OrderEntity createOrderInRepository(OrderTO order) {
            return order1;
        }

    }

    //createOrder - positive
    @Test
    public void shouldReturnOrder_ForCreateOrder_WhenAllPolesAreGiven() {
        //given
        OrderService orderService = new OrderServiceMock();
        //when
        OrderTO result = orderService.createOrder(firstName, secondName, address,
                PizzaMapper.mapToTOs(List.of(pizza1, pizza2)));
        //then
        assertEquals(date, result.getOrderDate());
    }

    //createOrder - negative
    @Test
    public void shouldReturnOrder_ForCreateOrder_WhenPizzasIsNull() {
        //given
        OrderService orderService = new OrderServiceMock();
        //when
        //then
        assertThrows(NullPointerException.class, () -> orderService.createOrder(firstName,
                secondName, address, PizzaMapper.mapToTOs(null)));
    }

}
