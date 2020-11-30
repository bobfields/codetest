package com.cgey.codetest;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(JUnitPlatform.class)
public class AppTest
{
    private static final MathContext MC = new MathContext(2, RoundingMode.HALF_UP);
    /**
     * Test calculate with sample data
     * Cafe X menu consists of the following items:
Cola - Cold – 50 cents
Coffee - Hot - $1.00
Cheese Sandwich - Cold - $2.00
Steak Sandwich - Hot - $4.50
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        MenuItem cola = new MenuItem(1, "Cola - Cold", "DRINK", new BigDecimal(.5));
        MenuItem coffee = new MenuItem(2, "Coffee - Hot", "DRINK", new BigDecimal(1));
        MenuItem cheese = new MenuItem(3, "Cheese Sandwich - Cold", "CHEESE", new BigDecimal(2));
        MenuItem steak = new MenuItem(4, "Steak Sandwich - Hot", "STEAK", new BigDecimal(4.5));
        List<MenuItem> items = new ArrayList<>(4);
        items.add(cola);
        items.add(coffee);
        items.add(cheese);
        items.add(steak);
        BigDecimal result = new App().calculateServiceCharge(items);
        System.out.println(result);
        assertEquals( "Incorrect Calculation", result, new BigDecimal(.65).round(MC) );
    }

    @Test
    public void mainTest()
    {
        // For code coverage only
        String args[] = {""};
        App.main(args);
    }

    @Test
    public void itemTest()
    {
        new MenuItem();
        // For code coverage only
        MenuItem cola = new MenuItem(1, "Cola - Cold", "DRINK", new BigDecimal(.5));
        cola.equals(cola);
        cola.setCost(new BigDecimal("20"));
        assertEquals( "Incorrect Cost", cola.getCost(), new BigDecimal("20").round(MC) );
        cola.setItem(10);
        assertEquals( "Incorrect Item", cola.getItem(), 10 );
        cola.setName("Cola");
        assertEquals( "Incorrect Name", cola.getName(), "Cola" );
        cola.setType("COLA");
        assertEquals( "Incorrect Type", cola.getType(), "COLA" );
        cola.toString();
        cola.hashCode();
        cola.equals(null);
        cola.equals(cola);
    }
}
