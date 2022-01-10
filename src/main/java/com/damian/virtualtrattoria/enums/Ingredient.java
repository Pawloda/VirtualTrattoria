package com.damian.virtualtrattoria.enums;

/**
 * Enum class with ingredients' names.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public enum Ingredient {

    DOUGH("DOUGH"), CHEESE("CHEESE"), TOMATO("TOMATO"),
    BASIL("BASIL"), HAM("HAM"), SALAMI("SALAMI"),
    MUSHROOMS("MUSHROOMS"), CAPERS("CAPERS"), PEPPER("PEPPER"),
    CHICKEN("CHICKEN"), PINEAPPLE("PINEAPPLE");

    private final String ingredientName;

    Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * It returns ingredient's name.
     *
     * @return ingredient's name in string.
     */
    public String toString() {
        return ingredientName;
    }
}
