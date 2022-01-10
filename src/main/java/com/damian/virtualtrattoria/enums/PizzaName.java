package com.damian.virtualtrattoria.enums;

import java.util.List;

/**
 * Enum class with pizzas' names, theirs poles and methods.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public enum PizzaName {

    MARGHERITA("MARGHERITA", true, List.of(Ingredient.DOUGH, Ingredient.CHEESE, Ingredient.BASIL, Ingredient.TOMATO), 16.99),
    CAPRICIOSA("CAPRICIOSA", true, List.of(Ingredient.DOUGH, Ingredient.CHEESE, Ingredient.TOMATO, Ingredient.HAM,
            Ingredient.MUSHROOMS, Ingredient.CAPERS), 21.99),
    CALZONE("CALZONE", true, List.of(Ingredient.DOUGH, Ingredient.CHEESE, Ingredient.TOMATO, Ingredient.HAM), 19.99),
    HAWAIIAN("HAWAIIAN", false, List.of(Ingredient.DOUGH, Ingredient.CHEESE, Ingredient.TOMATO, Ingredient.CHICKEN,
            Ingredient.PINEAPPLE), 20.99),
    FUNGHI("FUNGHI", false, List.of(Ingredient.DOUGH, Ingredient.CHEESE, Ingredient.BASIL, Ingredient.TOMATO,
            Ingredient.HAM), 18.99);

    private final String pizzaName;
    private final boolean availability;
    private final List<Ingredient> ingredients;
    private final double price;

    PizzaName(String pizzaName, boolean availability, List<Ingredient> ingredients, double price) {
        this.pizzaName = pizzaName;
        this.availability = availability;
        this.ingredients = ingredients;
        this.price = price;
    }

    /**
     * It shows if the pizza is currently available.
     *
     * @return true if it is available, false if you can't order this pizza now.
     */
    public boolean getAvailability() {
        return availability;
    }

    /**
     * It shows the pizza's ingredients.
     *
     * @return list with prime ingredients.
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * It shows the pizza's price.
     *
     * @return price of pizza without extra ingredients.
     */
    public double getPrice() {
        return price;
    }

    /**
     * It returns pizza's name.
     *
     * @return pizza's name in string.
     */
    public String toString() {
        return pizzaName;
    }

}
