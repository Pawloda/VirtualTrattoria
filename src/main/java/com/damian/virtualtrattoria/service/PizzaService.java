package com.damian.virtualtrattoria.service;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;
import com.damian.virtualtrattoria.to.PizzaTO;

import java.util.List;

/**
 * Class contains methods for creating new pizza object.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public interface PizzaService {

    /**
     * Methods takes pizza's name and extra ingredients and creates TO object.
     *
     * @param name        of the pizza.
     * @param ingredients given by client.
     * @return pizza TO with all information.
     */
    PizzaTO createPizza(PizzaName name, List<Ingredient> ingredients);

}
