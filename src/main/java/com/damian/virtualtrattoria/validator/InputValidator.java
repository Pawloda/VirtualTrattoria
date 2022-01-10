package com.damian.virtualtrattoria.validator;

import com.damian.virtualtrattoria.exception.BusinessException;
import com.damian.virtualtrattoria.strategy.PizzaChanger;
import com.damian.virtualtrattoria.to.PizzaTO;

/**
 * Class checks if the input given by user is valid. Contains 2 methods for
 * validating given by users name and address.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class InputValidator {

    /**
     * Method checks name given by user. Name should contains only letters.
     *
     * @param name of the customer given by user.
     * @return true if name is valid.
     * @throws BusinessException with information for the user that the name is invalid if name is invalid.
     */
    public static boolean isNameValid(String name) {
        if(name.matches("[(A-Za-z)|(ĄĆŚŁÓĘŻŹŃąćśłóężźń)]+")) {
            return true;
        }
        throw new BusinessException("Invalid name!");
    }

    /**
     * Method checks address given by user. Address should contains only letters and than numbers.
     *
     * @param address of the customer given by user.
     * @return true if name is valid.
     * @throws BusinessException with information for the user that the address is invalid if name is invalid.
     */
    public static boolean isAddressValid(String address) {
        if(address.matches("[(A-Za-z)|(ĄĆŚŁÓĘŻŹŃąćśłóężźń)]+[ ]" +
                "([(A-Za-z)|(ĄĆŚŁÓĘŻŹŃąćśłóężźń)]+[ ])*[0-9]+")) {
            return true;
        }
        throw new BusinessException("Invalid address!");
    }

    /**
     * Method checks number given by user.
     *
     * @param number of pizzas given by user.
     * @return true if number is valid.
     * @throws BusinessException with information for the user that the number is invalid if number is invalid.
     */
    public static boolean isNumberOfPizzasValid(String number) {
        if(number.matches("[1-9]+")) {
            return true;
        }
        throw new BusinessException("Invalid number!");
    }

    /**
     * Method checks number given by user.
     *
     * @param number of pizzas given by user.
     * @return true if number is valid.
     * @throws BusinessException with information for the user that the number is invalid if number is invalid.
     */
    public static boolean isPizzaNumberValid(String number) {
        if(number.matches("[1-5]")) {
            return true;
        }
        throw new BusinessException("Invalid number!");
    }

    /**
     * Method checks number given by user.
     *
     * @param number of ingredients given by user.
     * @return true if number is valid.
     * @throws BusinessException with information for the user that the number is invalid if number is invalid.
     */
    public static boolean isNumberOfIngredientsValid(String number) {
        if(number.matches("[0-3]")) {
            return true;
        }
        throw new BusinessException("Invalid number!");
    }

    /**
     * Method checks number given by user.
     *
     * @param number of pizzas given by user.
     * @return true if pizza is available
     * @throws BusinessException with information for the user that the pizza is not available now.
     */
    public static boolean isPizzaAvailable(String number) {
        PizzaTO pizza = PizzaChanger.createPizzaFromNumber(Integer.parseInt(number), null);
        if(pizza.getPizzaName().getAvailability()) {
            return true;
        }
        throw new BusinessException("Pizza is not available!");
    }
}
