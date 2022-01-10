package com.damian.virtualtrattoria.repository;

import com.damian.virtualtrattoria.entity.OrderEntity;
import com.damian.virtualtrattoria.repository.impl.OrderRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Class with tests for order's repository.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
@Suite
@SuiteDisplayName("Order Repository's Test")
public class OrderRepositoryTest {

    private final OrderEntity order1 = OrderEntity.builder().customerFirstName("Name1")
            .customerSecondName("Surname1").customerAddress("Address1").build();

    /**
     * Inner class overrides methods from order's repository.
     *
     * @author Damian
     * @version 1.0
     * @since 05.01.2022
     */
    private static final class OrderRepositoryMock extends OrderRepositoryImpl {

        @Override
        protected void saveOrdersIntoTheFile(List<OrderEntity> orders) {
            System.out.println("List saved - mock!");
        }

        @Override
        protected List<OrderEntity> getOrdersFromFile() {
            return new ArrayList<>();
        }

    }

    //createOrder - positive
    @Test
    public void shouldReturnNumber_ForCreateOrder_WhenOrderIsGiven() {
        //given
        OrderEntity order1 = OrderEntity.builder().customerFirstName("Name1")
                .customerSecondName("Surname1").customerAddress("Address1").build();
        OrderRepository orderRepository = new OrderRepositoryMock();
        //when
        OrderEntity result = orderRepository.createOrder(order1);
        //then
        assertEquals(1, result.getNumber());
    }

    @Test
    public void shouldReturnDate_ForCreateOrder_WhenOrderIsGiven() {
        //given
        OrderRepository orderRepository = new OrderRepositoryMock();
        //when
        OrderEntity result = orderRepository.createOrder(order1);
        //then
        assertNotNull(result.getOrderDate());
    }

    //createOrder - negative
    @Test
    public void shouldThrowsException_ForCreateOrder_WhenOrderIsNull() throws Exception {
        //given
        OrderRepository orderRepository = new OrderRepositoryMock();
        //when
        //then
        assertThrows(NullPointerException.class, () -> orderRepository.createOrder(null));
    }

}
