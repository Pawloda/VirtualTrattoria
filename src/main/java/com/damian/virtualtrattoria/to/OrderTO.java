package com.damian.virtualtrattoria.to;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Class of the order's TO.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
@Getter
@Setter
@Builder
public class OrderTO {

    private long number;
    private LocalDateTime orderDate;
    private String customerFirstName;
    private String customerSecondName;
    private String customerAddress;
    private List<PizzaTO> pizzas;
    private double amount;

    /**
     * Method used to display the sentence including all poles from order class
     * in proper form.
     *
     * @return result information contains order's number, customer's data, date of the order creation,
     * list of the pizzas and amount formatted to currency instance in string.
     */
    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "This is order number " + number + ":\n   Customer's name: ........... " + customerFirstName + " "
                + customerSecondName + "\n   Customer's address: ........ " + customerAddress
                + "\n   Order's creation date: ..... " + DateTimeFormatter.ISO_LOCAL_DATE.format(orderDate) + " at: "
                + DateTimeFormatter.ISO_LOCAL_TIME.format(orderDate).substring(0, 8) + "\n   Ordered pizzas:\n"
                + printPizzas() + "   Amount: " + formatter.format(amount) + "\n";
    }

    /**
     * Method used to display the list of pizzas.
     *
     * @return result information about every pizza included in order.
     */
    private String printPizzas() {
        StringBuilder result = new StringBuilder();
        for(PizzaTO pizza : pizzas) {
            result.append(pizza).append("\n");
        }
        return result.toString();
    }

}
