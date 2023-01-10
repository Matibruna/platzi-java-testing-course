package javatest.discounts;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Test
    public void total_zero_when_no_prices(){
        PriceCalculator calculator = new PriceCalculator();

        assertEquals(0, calculator.getTotal(), 0);
    }

    @Test
    public void total_is_not_zero_when_adding_prices(){
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice((double)20);
        calculator.addPrice((double)15);

        assertEquals(35, calculator.getTotal(), 0);
    }

    @Test
    public void apply_discount_to_prices(){
        PriceCalculator calculator = new PriceCalculator();

        double price1 = 72.7;
        double price2 = 42.96;
        calculator.addPrice(price1);
        calculator.addPrice(price2);

        double discount = 50;
        calculator.setDiscount(discount);

        assertEquals((price1+price2)*(100-discount)/100, calculator.getTotal(), 0);

    }

}