package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item [3 pts.]")
    void testAddValidItem() {
        assertDoesNotThrow(() -> cart.addItem("Book", 15.99));
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    void testAddItemWithZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Pen", 0.0));
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception) [3 pts.]")
    void testAddItemWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Notebook", -5.0));
    }

    @Test
    @DisplayName("Test applying 'SAVE10' discount [3 pts.]")
    void testApplyDiscountSave10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.01);
    }

    @Test
    @DisplayName("Test applying 'SAVE20' discount [3 pts.]")
    void testApplyDiscountSave20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.01);
    }

    @Test
    @DisplayName("Test applying invalid discount code (expect exception) [3 pts.]")
    void testApplyInvalidDiscountCode() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE50"));
    }

    @Test
    @DisplayName("Test total cost without discount [4 pts.]")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Item1", 20.0);
        cart.addItem("Item2", 30.0);
        assertEquals(50.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with discount [5 pts.]")
    void testTotalCostWithDiscount() {
        cart.addItem("Item1", 50.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(45.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with empty cart [3 pts.]")
    void testTotalCostWithEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.01);
    }

    // --- Additional Functional Tests for Robustness ---

    @Test
    @DisplayName("Test removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Laptop", 500.0);
        cart.removeItem("Laptop");
        assertEquals(0.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test removing non-existent item (no effect)")
    void testRemoveNonExistentItem() {
        cart.addItem("Mouse", 25.0);
        cart.removeItem("Keyboard");
        assertEquals(25.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test cart size updates correctly after adding/removing")
    void testCartSizeAfterAddRemove() {
        cart.addItem("Phone", 300.0);
        cart.addItem("Charger", 30.0);
        cart.removeItem("Charger");
        assertEquals(1, cart.getItemCount());
    }
}


