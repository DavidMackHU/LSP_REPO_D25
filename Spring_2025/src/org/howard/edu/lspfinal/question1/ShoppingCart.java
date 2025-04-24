package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * removing items, applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     * 
     * @param itemName  the name of the item
     * @param price     the price of the item (must be > 0)
     * @throws IllegalArgumentException if price is zero or negative
     */
    public void addItem(String itemName, double price) {
        if (price <= 0.0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        items.put(itemName, price);
    }

    /**
     * Removes an item from the cart. If the item does not exist, nothing happens.
     * 
     * @param itemName the name of the item to remove
     */
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discounts currently in effect.
     * 
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10": 10% discount
     * - "SAVE20": 20% discount
     * 
     * @param code  the discount code
     * @throws IllegalArgumentException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns the current discount percentage applied to the cart.
     * Useful for testing.
     * 
     * @return the discount percentage (0.0 if no discount applied)
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * Returns the number of items currently in the cart.
     * 
     * @return the item count
     */
    public int getItemCount() {
        return items.size();
    }
}
