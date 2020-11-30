package com.cgey.codetest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

/**
 * generate a bill including a service charge so customers don’t have to work out how much to tip.
 * Due to rounding possibilities, use BigDecimal datatype to represent currency. Or Joda/Java Money API for Java 8+
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    // Static values for performance reasons
    private static final String DRINK = "DRINK";
    // PMD: Use a String literal to create new BigDecimal rather than float / decimal
    private static final BigDecimal TENTH = new BigDecimal(".1");
    /**
     *
     */
    public static final MathContext MC = new MathContext(2, RoundingMode.HALF_UP);

    /**
     * Pass in a list of purchased items that produces a total bill
     * When all purchased items are drinks no service charge is applied
     * When purchased items include any food apply a service charge of 10% to the total bill (rounded to 2 decimal places)
     * @param items
     * @return
     */
    public BigDecimal calculateServiceCharge(List<MenuItem> items) {
        BigDecimal calc = new BigDecimal(0);
        for (MenuItem item : items) {
            //System.out.println("cost=" + item.getCost() + " tenth=" + item.getCost().multiply(TENTH) + " calc=" + calc + " " + item);
            if (!item.getType().equalsIgnoreCase(DRINK)) {
                BigDecimal add = item.getCost().multiply(TENTH);
                calc = calc.add(add);
                //System.out.println("cost=" + item.getCost() + " tenth=" + item.getCost().multiply(TENTH) + " calc=" + calc + " add=" + add);
            }
        }
        return calc.round(MC);
    }
}
