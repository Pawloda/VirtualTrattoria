package com.damian.virtualtrattoria.service;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;
import com.damian.virtualtrattoria.service.impl.PizzaServiceImpl;
import com.damian.virtualtrattoria.to.PizzaTO;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Class with tests for pizza's service.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
@Suite
@SuiteDisplayName("Input Pizza Service's Test")
public class PizzaServiceTest {

    PizzaService pizzaService = new PizzaServiceImpl();

    //createPizza - positive
    @Test
    public void shouldReturnNull_ForCreatePizza_WhenPizzaNameMARGHERITAIsGiven() {
        //given
        //when
        PizzaTO result = pizzaService.createPizza(null, null);
        //then
        assertNull(result.getPizzaName());
    }

    @Test
    public void shouldReturnMARGHERITA_ForCreatePizza_WhenPizzaNameMARGHERITAIsGiven() {
        //given
        PizzaName pizzaName = PizzaName.MARGHERITA;
        //when
        PizzaTO result = pizzaService.createPizza(pizzaName, null);
        //then
        assertEquals(pizzaName, result.getPizzaName());
    }

    @Test
    public void shouldReturnCALZONE_ForCreatePizza_WhenPizzaNameCALZONEIsGiven() {
        //given
        PizzaName pizzaName = PizzaName.CALZONE;
        //when
        PizzaTO result = pizzaService.createPizza(pizzaName, null);
        //then
        assertEquals(pizzaName, result.getPizzaName());
    }

    @Test
    public void shouldReturnIngredients_ForCreatePizza_WhenIngredientsAreGiven() {
        //given
        PizzaName pizzaName = PizzaName.MARGHERITA;
        List<Ingredient> ingredients = List.of(Ingredient.CHEESE, Ingredient.PINEAPPLE);
        //when
        PizzaTO result = pizzaService.createPizza(pizzaName, ingredients);
        //then
        assertEquals(ingredients, result.getExtraIngredients());
    }

    //createPizza - there are no negative cases

}
