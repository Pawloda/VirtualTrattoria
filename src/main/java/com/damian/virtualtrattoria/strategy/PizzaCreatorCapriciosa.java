package com.damian.virtualtrattoria.strategy;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;
import com.damian.virtualtrattoria.service.PizzaService;
import com.damian.virtualtrattoria.service.impl.PizzaServiceImpl;
import com.damian.virtualtrattoria.to.PizzaTO;

import java.util.List;

/**
 * Class implements interface of pizza's creator. For capriciosa pizza.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class PizzaCreatorCapriciosa implements PizzaCreator {

    PizzaService pizzaService = new PizzaServiceImpl();

    @Override
    public PizzaTO createPizza(List<Ingredient> ingredients) {
        return pizzaService.createPizza(PizzaName.CAPRICIOSA, ingredients);
    }

}
