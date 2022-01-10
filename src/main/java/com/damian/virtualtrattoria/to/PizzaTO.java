package com.damian.virtualtrattoria.to;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;
import com.damian.virtualtrattoria.service.TextService;
import com.damian.virtualtrattoria.service.impl.TextServiceImpl;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.text.NumberFormat;
import java.util.List;

/**
 * Class of the pizza's TO.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
@Getter
@Setter
@Builder
public class PizzaTO {

    private final TextService textService = new TextServiceImpl();
    private final PizzaName pizzaName;
    private final List<Ingredient> extraIngredients;

    /**
     * Method used to display the sentence including all poles from pizza class
     * in proper form.
     *
     * @return result information contains pizza name, extra ingredients and price.
     */
    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        StringBuilder pizzaDescription = new StringBuilder();
        String convertedPizzaName = textService.convertTextToValidFormat(pizzaName.toString());
        pizzaDescription.append("      - ").append(convertedPizzaName).append(" ");
        pizzaDescription = appendDescriptionWithIngredientsIfThereAreOnes(pizzaDescription);
        pizzaDescription.append("- price: ").append(formatter.format(getFullPizzaWithIngredientsPrice()));
        return pizzaDescription.toString();
    }

    /**
     * It appends string with extra ingredients if there are some.
     *
     * @return string with pizza information.
     */
    private StringBuilder appendDescriptionWithIngredientsIfThereAreOnes(StringBuilder pizzaDescription) {
        if(extraIngredients != null) {
            if(extraIngredients.size() != 0) {
                pizzaDescription = appendDescriptionWithIngredients(pizzaDescription);
            }
        }
        return pizzaDescription;
    }

    /**
     * It appends string with extra ingredients.
     *
     * @return string with pizza information.
     */
    private StringBuilder appendDescriptionWithIngredients(StringBuilder pizzaDescription) {
        pizzaDescription.append("extra: ");
        for(Ingredient ingredient : extraIngredients) {
            String ingredientName = textService.convertTextToValidFormat(ingredient.toString());
            pizzaDescription.append(ingredientName).append(", ");
        }
        return pizzaDescription.delete(pizzaDescription.length() - 2, pizzaDescription.length() - 1);
    }

    /**
     * It counts the price of the pizza with all extra ingredients.
     *
     * @return price in double.
     */
    public double getFullPizzaWithIngredientsPrice() {
        return getPizzaName().getPrice() + getExtraIngredients().size() * 3;
    }

}
