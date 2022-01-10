package com.damian.virtualtrattoria.entity;

import com.damian.virtualtrattoria.enums.Ingredient;
import com.damian.virtualtrattoria.enums.PizzaName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class of the pizza's entity.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
@Getter
@Setter
@Builder
public class PizzaEntity {

    private PizzaName pizzaName;
    private List<Ingredient> extraIngredients;

}
