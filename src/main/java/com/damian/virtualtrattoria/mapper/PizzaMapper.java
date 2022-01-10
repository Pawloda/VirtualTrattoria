package com.damian.virtualtrattoria.mapper;

import com.damian.virtualtrattoria.entity.PizzaEntity;
import com.damian.virtualtrattoria.to.PizzaTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of the mapper for pizzas.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class PizzaMapper {

    /**
     * This method creates pizza entity from TO.
     *
     * @param pizza given pizza in TO.
     * @return pizza in entity form.
     */
    public static PizzaEntity mapToEntity(PizzaTO pizza) {
        return PizzaEntity.builder().pizzaName(pizza.getPizzaName())
                .extraIngredients(pizza.getExtraIngredients()).build();
    }

    /**
     * This method creates pizza TO from entity.
     *
     * @param pizza given pizza in entity.
     * @return pizza in TO form.
     */
    public static PizzaTO mapToTO(PizzaEntity pizza) {
        return PizzaTO.builder().pizzaName(pizza.getPizzaName())
                .extraIngredients(pizza.getExtraIngredients()).build();
    }

    /**
     * This method creates pizza entities from TOs.
     *
     * @param pizzas given pizza in TOs.
     * @return pizzas in entities forms.
     */
    public static List<PizzaEntity> mapToEntities(List<PizzaTO> pizzas) {
        List<PizzaEntity> results = new ArrayList<>();
        for(PizzaTO pizza : pizzas) {
            results.add(mapToEntity(pizza));
        }
        return results;
    }

    /**
     * This method creates pizza TOs from entities.
     *
     * @param pizzas given pizza in entities.
     * @return pizzas in TO forms.
     */
    public static List<PizzaTO> mapToTOs(List<PizzaEntity> pizzas) {
        List<PizzaTO> results = new ArrayList<>();
        for(PizzaEntity pizza : pizzas) {
            results.add(mapToTO(pizza));
        }
        return results;
    }

}
