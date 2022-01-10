package com.damian.virtualtrattoria.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class of the order's entity.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
@Getter
@Setter
@Builder
public class OrderEntity {

    private long number;
    private LocalDateTime orderDate;
    private String customerFirstName;
    private String customerSecondName;
    private String customerAddress;
    private List<PizzaEntity> pizzas;
    private double amount;

}
