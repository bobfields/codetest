/**
 * Menu Item consisting of Number, Name, Type, Cost.
 */
package com.cgey.codetest;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * MenuItem: Id/Name, Type, and cost
 * @author RJF3
 */
public class MenuItem {
    private int item;
    private String name;
    // Drink or non drink
    private String type;
    private BigDecimal cost;

    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MenuItem [item=").append(item).append(", name=").append(name).append(", type=").append(type)
                .append(", cost=").append(cost).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) obj;
        return Objects.equals(name, other.name);
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the cost
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


    /**
     *
     */
    public MenuItem() {
        // TODO Auto-generated constructor stub
    }


    /**
     * @param item Item number for database
     * @param name Item Name (descriptive)
     * @param type Item type (DRINK or anything else)
     * @param cost Money cost (2 decimal places)
     */
    public MenuItem(int item, String name, String type, BigDecimal cost) {
        super();
        this.item = item;
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
