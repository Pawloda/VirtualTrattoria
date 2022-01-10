package com.damian.virtualtrattoria.validator;

import com.damian.virtualtrattoria.enums.PizzaName;
import com.damian.virtualtrattoria.exception.BusinessException;

import com.damian.virtualtrattoria.strategy.PizzaChanger;
import com.damian.virtualtrattoria.to.PizzaTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import org.mockito.Mockito;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class with tests for validators. It uses mockito and parameterized tests.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
@Suite
@SuiteDisplayName("Input Validator's Test")
public class InputValidatorTest {

    //isNameValid - positive
    @ParameterizedTest
    @ValueSource(strings = { "Mike", "mike", "ANN", "XYZ", "ŹĄŚĆ" })
    public void shouldReturnTrue_ForIsNameValid_WhenNameIsValid(String name) {
        //given
        //when
        boolean result = InputValidator.isNameValid(name);
        //then
        assertTrue(result);
    }

    //isNameValid - negative
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "0", "Mike1", "Yo yo", "A.nn", " Mike", "Paul " })
    public void shouldThrowsException_ForIsNameValid_WhenNameIsInvalid(String name) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isNameValid(name));
    }

    //isAddressValid - positive
    @ParameterizedTest
    @ValueSource(strings = { "Street 11", "street 302", "STR 5", "ŹĄŚĆ 3232", "str str 302", "ŹĄŚĆ ŹĄŚĆ ŹĄŚĆ 3232" })
    public void shouldReturnTrue_ForIsAddressValid_WhenAddressIsValid(String address) {
        //given
        //when
        boolean result = InputValidator.isAddressValid(address);
        //then
        assertTrue(result);
    }

    //isAddressValid - negative
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "0", "Street1", "Yo yo1", "S.treet", " str str 302", "STR  5", "STR 5 3" })
    public void shouldThrowsException_ForIsAddressValid_WhenAddressIsInvalid(String address) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isAddressValid(address));
    }

    //isNumberOfPizzasValid - positive
    @ParameterizedTest
    @ValueSource(strings = { "1", "12", "1111" })
    public void shouldReturnTrue_ForIsNumberOfPizzasValid_WhenNumberOfPizzasIsValid(String number) {
        //given
        //when
        boolean result = InputValidator.isNumberOfPizzasValid(number);
        //then
        assertTrue(result);
    }

    //isNumberOfPizzasValid - negative
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "0", "-1", "1,4", "5.5", "FIVE", "1024O" })
    public void shouldThrowsException_ForIsNumberOfPizzasValid_WhenNumberOfPizzasIsInvalid(String number) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isNumberOfPizzasValid(number));
    }

    //isPizzaNumberValid - positive
    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "3" })
    public void shouldReturnTrue_ForIsPizzaNumberValid_WhenPizzaNumberIsValid(String number) {
        //given
        //when
        boolean result = InputValidator.isPizzaNumberValid(number);
        //then
        assertTrue(result);
    }

    //isPizzaNumberValid - negative
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "0", "-1", "1,4", "5.5", "FIVE", "6" })
    public void shouldThrowsException_ForIsPizzaNumberValid_WhenPizzaNumberIsInvalid(String number) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isPizzaNumberValid(number));
    }

    //isNumberOfIngredientsValid - positive
    @ParameterizedTest
    @ValueSource(strings = { "0", "1", "2", "3" })
    public void shouldReturnTrue_ForIsNumberOfIngredientsValid_WhenNumberOfIngredientsIsValid(String number) {
        //given
        //when
        boolean result = InputValidator.isNumberOfIngredientsValid(number);
        //then
        assertTrue(result);
    }

    //isNumberOfIngredientsValid - negative
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "-1", "1,4", "5.5", "FIVE", "4" })
    public void shouldThrowsException_ForIsNumberOfIngredientsValid_WhenNumberOfIngredientsIsInvalid(String number) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isNumberOfIngredientsValid(number));
    }

    //checkAvailability - positive
    @ParameterizedTest
    @ValueSource(strings = { "1", "3", "4" })
    public void shouldReturnTrue_ForCheckAvailability_WhenPizzaIsAvailable(String number) {
        try(MockedStatic<PizzaChanger> mocked = Mockito.mockStatic(PizzaChanger.class)) {
            //given
            PizzaTO pizza1 = PizzaTO.builder().pizzaName(PizzaName.MARGHERITA).build();
            PizzaTO pizza3 = PizzaTO.builder().pizzaName(PizzaName.CALZONE).build();
            PizzaTO pizza4 = PizzaTO.builder().pizzaName(PizzaName.CAPRICIOSA).build();
            //when
            mocked.when(() -> PizzaChanger.createPizzaFromNumber(1, null)).thenReturn(pizza1);
            mocked.when(() -> PizzaChanger.createPizzaFromNumber(3, null)).thenReturn(pizza3);
            mocked.when(() -> PizzaChanger.createPizzaFromNumber(4, null)).thenReturn(pizza4);
            boolean result = InputValidator.isPizzaAvailable(number);
            //then
            assertTrue(result);
        }
    }

    //checkAvailability - negative
    @ParameterizedTest
    @ValueSource(strings = { "2", "5" })
    public void shouldThrowsException_ForCheckAvailability_WhenPizzaIsUnavailable(String number) {
        try(MockedStatic<PizzaChanger> mocked = Mockito.mockStatic(PizzaChanger.class)) {
            //given
            PizzaTO pizza2 = PizzaTO.builder().pizzaName(PizzaName.FUNGHI).build();
            PizzaTO pizza5 = PizzaTO.builder().pizzaName(PizzaName.HAWAIIAN).build();
            //when
            mocked.when(() -> PizzaChanger.createPizzaFromNumber(2, null)).thenReturn(pizza2);
            mocked.when(() -> PizzaChanger.createPizzaFromNumber(5, null)).thenReturn(pizza5);
            //then
            assertThrows(BusinessException.class, () -> InputValidator.isPizzaAvailable(number));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "0", "100" })
    public void shouldThrowsException_ForCheckAvailability_WhenPizzaNumberIsNotInMenu(String number) {
        try(MockedStatic<PizzaChanger> mocked = Mockito.mockStatic(PizzaChanger.class)) {
            //given
            //when
            //then
            assertThrows(NullPointerException.class, () -> InputValidator.isPizzaAvailable(number));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "Hi", "4.5" })
    public void shouldThrowsException_ForCheckAvailability_WhenNumberFormatIsInvalid(String number) {
        try(MockedStatic<PizzaChanger> mocked = Mockito.mockStatic(PizzaChanger.class)) {
            //given
            //when
            //then
            assertThrows(NumberFormatException.class, () -> InputValidator.isPizzaAvailable(number));
        }
    }

}
