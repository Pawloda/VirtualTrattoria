package com.damian.virtualtrattoria.strategy;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.to.PizzaTO;

import java.util.List;

/**
 * Interface contains method creating from given list of ingredients pizza's TO.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public interface PizzaCreator {

    /**
     * It creates pizza using pizza service depends on given ingredients for every pizza type.
     *
     * @param ingredients given by user.
     * @return pizza TO object.
     */
    PizzaTO createPizza(List<Ingredient> ingredients);

}
