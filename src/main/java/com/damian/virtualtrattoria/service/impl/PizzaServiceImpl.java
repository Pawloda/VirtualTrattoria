package com.damian.virtualtrattoria.service.impl;


import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;

import com.damian.virtualtrattoria.service.PizzaService;
import com.damian.virtualtrattoria.to.PizzaTO;

import java.util.List;

/**
 * Class implements interface of pizza's service.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class PizzaServiceImpl implements PizzaService {

    @Override
    public PizzaTO createPizza(PizzaName pizzaName, List<Ingredient> ingredients) {
        return PizzaTO.builder().pizzaName(pizzaName).extraIngredients(ingredients).build();
    }

}
