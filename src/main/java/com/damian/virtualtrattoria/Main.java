package com.damian.virtualtrattoria;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;
import com.damian.virtualtrattoria.exception.BusinessException;
import com.damian.virtualtrattoria.service.TextService;
import com.damian.virtualtrattoria.service.impl.OrderServiceImpl;
import com.damian.virtualtrattoria.service.impl.TextServiceImpl;
import com.damian.virtualtrattoria.strategy.PizzaChanger;
import com.damian.virtualtrattoria.to.OrderTO;
import com.damian.virtualtrattoria.to.PizzaTO;
import com.damian.virtualtrattoria.validator.InputValidator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class of the application.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TextService textService = new TextServiceImpl();

    /**
     * Method needed to start the application. It runs all necessary methods
     * and takes information from the user. It takes data about customer and creates
     * the order.
     *
     * @param args strings table.
     */
    public static void main(String[] args) {
        System.out.print("\n*** Hello in Virtual Trattoria! ***\n\nEnter you first name: ");
        String firstName = textService.convertTextToValidFormat(takeNameFromUser());
        System.out.print("\nEnter you second name: ");
        String secondName = textService.convertTextToValidFormat(takeNameFromUser());
        System.out.print("\nEnter your address: ");
        String address = textService.convertTextToValidFormat(takeAddressFromUser());
        List<PizzaTO> pizzas = takePizzasFromUser();
        OrderServiceImpl orderService = new OrderServiceImpl();
        OrderTO order = orderService.createOrder(firstName, secondName, address, pizzas);
        System.out.print("\n**************************\n" + order);
        scanner.close();
    }

    /**
     * Method takes from user name and validates it. If the name is incorrect it repeats
     * until user gives proper data.
     *
     * @return name in string.
     */
    private static String takeNameFromUser() {
        String name;
        boolean validator = false;
        do {
            name = scanner.nextLine();
            try {
                validator = InputValidator.isNameValid(name);
            } catch(BusinessException exception) {
                System.out.print("Invalid name! You can use only letters. Please put it again: ");
            }
        } while(!validator);
        return name;
    }

    /**
     * Method takes from user name and validates it. If the name is incorrect it repeats
     * until user gives proper data.
     *
     * @return address in string.
     */
    private static String takeAddressFromUser() {
        String address;
        boolean validator = false;
        do {
            address = scanner.nextLine();
            try {
                validator = InputValidator.isAddressValid(address);
            } catch(BusinessException exception) {
                System.out.print("Invalid address! You should use letters, " +
                        "single spaces and give a number of the street in the end. Please put it again: ");
            }
        } while(!validator);
        return address;
    }

    /**
     * Method takes from user name and validates it. If the name is incorrect it repeats
     * until user gives proper data.
     *
     * @return name in string.
     */
    private static List<PizzaTO> takePizzasFromUser() {
        List<PizzaTO> pizzas = new ArrayList<>();
        System.out.print("\nEnter how many pizzas do you want: ");
        int number = Integer.parseInt(takeNumberOfPizzasFromUser());
        for(int i = 1; i <= number; i++) {
            int pizzaNumber = displayMenuAndTakePizzaNumberFromUser(i);
            List<Ingredient> ingredients = displayInfoAndTakeIngredientsFromUser();
            pizzas.add(PizzaChanger.createPizzaFromNumber(pizzaNumber, ingredients));
        }
        return pizzas;
    }

    /**
     * Method takes from user number and validates it. If the number is incorrect it repeats
     * until user gives proper data.
     *
     * @return number in string.
     */
    private static String takeNumberOfPizzasFromUser() {
        String numberOfPizzas;
        boolean validator = false;
        do {
            numberOfPizzas = scanner.nextLine();
            try {
                validator = InputValidator.isNumberOfPizzasValid(numberOfPizzas);
            } catch(BusinessException exception) {
                System.out.print("Invalid number! You should use integers bigger than 0. Please put it again: ");
            }
        } while(!validator);
        return numberOfPizzas;
    }

    /**
     * Method displays menu and take pizza number from user.
     *
     * @param i number of pizza ordered by user.
     * @return number in integer.
     */
    private static int displayMenuAndTakePizzaNumberFromUser(int i) {
        System.out.print("\nPizzas:\n1. " + PizzaName.MARGHERITA + "\n2. "
                + PizzaName.FUNGHI + "\n3. " + PizzaName.CALZONE + "\n4. " + PizzaName.CAPRICIOSA
                + "\n5. " + PizzaName.HAWAIIAN + "\n\nSelect your " + i + " pizza: ");
        return Integer.parseInt(takePizzaNumberFromUser());
    }

    /**
     * Method displays information about ingredients, take from user number of ingredients for pizza
     * and take ingredients from user.
     *
     * @return list of ingredients.
     */
    private static List<Ingredient> displayInfoAndTakeIngredientsFromUser() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.print("\nEvery ingredient costs: " + formatter.format(3) + "." +
                "\nEnter how many do you want - from 0 to 3: ");
        int numberOfIngredients = Integer.parseInt(takeNumberOfIngredientsFromUser());
        return takeIngredientsFromUser(numberOfIngredients);
    }

    /**
     * Method takes from user number and validates it. If the number is incorrect it repeats
     * until user gives proper data. Then method checks availability of pizza.
     *
     * @return number in string.
     */
    private static String takePizzaNumberFromUser() {
        String pizzaNumber;
        boolean validator1 = false;
        boolean validator2 = false;
        do {
            pizzaNumber = scanner.nextLine();
            try {
                validator1 = InputValidator.isPizzaNumberValid(pizzaNumber);
            } catch(BusinessException exception) {
                System.out.print("Invalid number! You should use integers from 1 to 5. Please put it again: ");
            }
            try {
                validator2 = InputValidator.isPizzaAvailable(pizzaNumber);
            } catch(BusinessException exception) {
                System.out.print("Pizza is currently not available. Please take another one: ");
            }
        } while(!validator1 || !validator2);
        return pizzaNumber;
    }

    /**
     * Method takes from user number and validates it. If the number is incorrect it repeats
     * until user gives proper data.
     *
     * @return number in string.
     */
    private static String takeNumberOfIngredientsFromUser() {
        String numberOfIngredients;
        boolean validator = false;
        do {
            numberOfIngredients = scanner.nextLine();
            try {
                validator = InputValidator.isNumberOfIngredientsValid(numberOfIngredients);
            } catch(BusinessException exception) {
                System.out.print("Invalid number! You should use integers from 0 to 3. Please put it again: ");
            }
        } while(!validator);
        return numberOfIngredients;
    }

    /**
     * Method takes number of ingredients. It creates the list of ingredients for pizza.
     *
     * @return list of ingredients.
     */
    private static List<Ingredient> takeIngredientsFromUser(int numberOfIngredients) {
        List<Ingredient> ingredients = new ArrayList<>();
        for(int i = 1; i <= numberOfIngredients; i++) {
            ingredients.add(displayIngredientsAndTakeIngredientFromUser(i));
        }
        return ingredients;
    }

    /**
     * It takes the number of ingredient, check it's validity and returns proper ingredient.
     *
     * @return ingredient.
     */
    private static Ingredient displayIngredientsAndTakeIngredientFromUser(int i) {
        System.out.print("\nIngredients:\n1. " + Ingredient.CHEESE + "\n2. " + Ingredient.PEPPER + "\n3. "
                + Ingredient.SALAMI + "\n4. " + Ingredient.PINEAPPLE + "\n5. " + Ingredient.CHICKEN
                + "\n\nSelect extra " + i + " ingredient for your pizza: ");
        int ingredientNumber = Integer.parseInt(takeIngredientNumberFromUser());
        return selectIngredientByGivenNumber(ingredientNumber);
    }

    /**
     * It takes the number of ingredient, check it's validity and returns proper ingredient.
     *
     * @return ingredient.
     */
    private static String takeIngredientNumberFromUser() {
        String ingredientsNumber;
        boolean validator = false;
        do {
            ingredientsNumber = scanner.nextLine();
            try {
                validator = InputValidator.isPizzaNumberValid(ingredientsNumber);
            } catch(BusinessException exception) {
                System.out.print("Invalid number! You should use integers from 1 to 5. Please put it again: ");
            }
        } while(!validator);
        return ingredientsNumber;
    }

    /**
     * It takes the number of ingredient and returns proper ingredient depends on number by switch.
     *
     * @return ingredient.
     */
    private static Ingredient selectIngredientByGivenNumber(int number) {
        Ingredient ingredient;
        switch(number) {
            case 1:
                ingredient = Ingredient.CHEESE;
                break;
            case 2:
                ingredient = Ingredient.PEPPER;
                break;
            case 3:
                ingredient = Ingredient.SALAMI;
                break;
            case 4:
                ingredient = Ingredient.PINEAPPLE;
                break;
            default:
                ingredient = Ingredient.CHICKEN;
                break;
        }
        return ingredient;
    }

}
