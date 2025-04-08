package org.howard.edu.ls.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;
    private IntegerSet set3;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
        set3 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear method")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty(), "Set should be empty after clear");
    }

    @Test
    @DisplayName("Test case for length method")
    public void testLength() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length(), "Length should be 3");

        set1.clear();
        assertEquals(0, set1.length(), "Length should be 0 after clear");
    }

    @Test
    @DisplayName("Test case for equals method")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        set3.add(3);

        assertTrue(set1.equals(set2), "Sets should be equal");
        assertFalse(set1.equals(set3), "Sets should not be equal");
    }

    @Test
    @DisplayName("Test case for contains method")
    public void testContains() {
        set1.add(1);
        set1.add(2);

        assertTrue(set1.contains(1), "Set should contain 1");
        assertFalse(set1.contains(3), "Set should not contain 3");
    }

    @Test
    @DisplayName("Test case for largest method")
    public void testLargest() {
        set1.add(1);
        set1.add(5);
        set1.add(3);

        assertEquals(5, set1.largest(), "Largest should be 5");

        set1.clear();
        assertThrows(IntegerSetException.class, () -> set1.largest(), "Should throw IntegerSetException when set is empty");
    }

    @Test
    @DisplayName("Test case for smallest method")
    public void testSmallest() {
        set1.add(1);
        set1.add(5);
        set1.add(3);

        assertEquals(1, set1.smallest(), "Smallest should be 1");

        set1.clear();
        assertThrows(IntegerSetException.class, () -> set1.smallest(), "Should throw IntegerSetException when set is empty");
    }

    @Test
    @DisplayName("Test case for add method")
    public void testAdd() {
        set1.add(1);
        set1.add(1); // Adding a duplicate value

        assertEquals(1, set1.length(), "Length should be 1 after adding a duplicate");
    }

    @Test
    @DisplayName("Test case for remove method")
    public void testRemove() {
        set1.add(1);
        set1.remove(1);

        assertFalse(set1.contains(1), "Set should not contain 1 after removal");
    }

    @Test
    @DisplayName("Test case for union method")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);

        set1.union(set2);
        assertTrue(set1.contains(1), "Set should contain 1 after union");
        assertTrue(set1.contains(2), "Set should contain 2 after union");
        assertTrue(set1.contains(3), "Set should contain 3 after union");
    }

    @Test
    @DisplayName("Test case for intersect method")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);

        set1.intersect(set2);
        assertTrue(set1.contains(2), "Set should contain 2 after intersection");
        assertFalse(set1.contains(1), "Set should not contain 1 after intersection");
        assertFalse(set1.contains(3), "Set should not contain 3 after intersection");
    }

    @Test
    @DisplayName("Test case for diff method")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);

        set1.diff(set2);
        assertTrue(set1.contains(1), "Set should contain 1 after diff");
        assertFalse(set1.contains(2), "Set should not contain 2 after diff");
        assertFalse(set1.contains(3), "Set should not contain 3 after diff");
    }

    @Test
    @DisplayName("Test case for complement method")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);

        set1.complement(set2);
        assertFalse(set1.contains(2), "Set should not contain 2 after complement");
        assertTrue(set1.contains(1), "Set should contain 1 after complement");
        assertFalse(set1.contains(3), "Set should not contain 3 after complement");
    }

    @Test
    @DisplayName("Test case for isEmpty method")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty(), "Set should be empty initially");
        set1.add(1);
        assertFalse(set1.isEmpty(), "Set should not be empty after adding an item");
    }

    @Test
    @DisplayName("Test case for toString method")
    public void testToString() {
        set1.add(1);
        set1.add(2);

        String result = set1.toString();
        assertTrue(result.contains("1"), "String representation should contain 1");
        assertTrue(result.contains("2"), "String representation should contain 2");
    }
}
