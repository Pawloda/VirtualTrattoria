package com.damian.virtualtrattoria.strategy;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.exception.BusinessException;
import com.damian.virtualtrattoria.to.PizzaTO;

import java.util.List;

/**
 * Class gives the right strategy depends on pizza's number.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class PizzaChanger {

    /**
     * Method gives pizza depends on number given by user. It uses strategy pattern.
     *
     * @param pizzaNumber given by user.
     * @param ingredients given by user.
     * @return pizza object in TO format.
     */
    public static PizzaTO createPizzaFromNumber(int pizzaNumber, List<Ingredient> ingredients) {
        PizzaCreator pizzaCreator;
        if(pizzaNumber == 1) {
            pizzaCreator = new PizzaCreatorMargherita();
        } else if(pizzaNumber == 2) {
            pizzaCreator = new PizzaCreatorFunghi();
        } else if(pizzaNumber == 3) {
            pizzaCreator = new PizzaCreatorCalzone();
        } else if(pizzaNumber == 4) {
            pizzaCreator = new PizzaCreatorCapriciosa();
        } else if(pizzaNumber == 5){
            pizzaCreator = new PizzaCreatorHawaiian();
        } else
            throw new BusinessException("There is no such pizza!");
        return pizzaCreator.createPizza(ingredients);
    }

}
