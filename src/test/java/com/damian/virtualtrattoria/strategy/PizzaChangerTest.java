package com.damian.virtualtrattoria.strategy;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;
import com.damian.virtualtrattoria.exception.BusinessException;
import com.damian.virtualtrattoria.to.PizzaTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class with tests for strategy.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
@Suite
@SuiteDisplayName("Input Pizza Changer's Test")
public class PizzaChangerTest {

    //createPizzaFromNumber - positive
    @Test
    public void shouldReturnMARGHERITA_ForCreatePizzaFromNumber_WhenNumberIs1() {
        //given
        List<Ingredient> ingredients = List.of(Ingredient.CHEESE, Ingredient.PINEAPPLE);
        //when
        PizzaTO result = PizzaChanger.createPizzaFromNumber(1, ingredients);
        //then
        assertEquals(PizzaName.MARGHERITA, result.getPizzaName());
        assertEquals(ingredients, result.getExtraIngredients());
    }

    @Test
    public void shouldReturnFUNGHI_ForCreatePizzaFromNumber_WhenNumberIs2() {
        //given
        List<Ingredient> ingredients = List.of(Ingredient.CHEESE, Ingredient.PINEAPPLE);
        //when
        PizzaTO result = PizzaChanger.createPizzaFromNumber(2, ingredients);
        //then
        assertEquals(PizzaName.FUNGHI, result.getPizzaName());
        assertEquals(ingredients, result.getExtraIngredients());
    }

    @Test
    public void shouldReturnCALZONE_ForCreatePizzaFromNumber_WhenNumberIs3() {
        //given
        List<Ingredient> ingredients = List.of(Ingredient.CHEESE, Ingredient.PINEAPPLE);
        //when
        PizzaTO result = PizzaChanger.createPizzaFromNumber(3, ingredients);
        //then
        assertEquals(PizzaName.CALZONE, result.getPizzaName());
        assertEquals(ingredients, result.getExtraIngredients());
    }

    @Test
    public void shouldReturnCAPRICIOSA_ForCreatePizzaFromNumber_WhenNumberIs4() {
        //given
        List<Ingredient> ingredients = List.of(Ingredient.CHEESE, Ingredient.PINEAPPLE);
        //when
        PizzaTO result = PizzaChanger.createPizzaFromNumber(4, ingredients);
        //then
        assertEquals(PizzaName.CAPRICIOSA, result.getPizzaName());
        assertEquals(ingredients, result.getExtraIngredients());
    }

    @Test
    public void shouldReturnHAWAIIAN_ForCreatePizzaFromNumber_WhenNumberIs5() {
        //given
        List<Ingredient> ingredients = List.of(Ingredient.CHEESE, Ingredient.PINEAPPLE);
        //when
        PizzaTO result = PizzaChanger.createPizzaFromNumber(5, ingredients);
        //then
        assertEquals(PizzaName.HAWAIIAN, result.getPizzaName());
        assertEquals(ingredients, result.getExtraIngredients());
    }

    //checkAvailability - negative
    @ParameterizedTest
    @ValueSource(ints = { 0, 43, -3 })
    public void shouldThrowsException_ForCreatePizzaFromNumber_WhenNumberIsInvalid(int number) {
        //given
        List<Ingredient> ingredients = List.of(Ingredient.CHEESE, Ingredient.PINEAPPLE);
        //when
        //then
        assertThrows(BusinessException.class, () -> PizzaChanger.createPizzaFromNumber(number, ingredients));
    }

}
