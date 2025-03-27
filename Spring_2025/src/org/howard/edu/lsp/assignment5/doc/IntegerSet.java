package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a set of integers, providing methods for various set operations.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<>();

    /**
     * Default constructor initializing an empty set.
     */
    public IntegerSet() {
    }

    /**
     * Constructor initializing the set with given values, ensuring uniqueness.
     * @param set Initial set values.
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (int num : set) {
            add(num);
        }
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal.
     * @param o The object to compare with.
     * @return true if both sets have the same elements, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet otherSet = (IntegerSet) o;
        return set.containsAll(otherSet.set) && otherSet.set.containsAll(set);
    }

    /**
     * Checks if the set contains a specific value.
     * @param value The value to check for.
     * @return true if the value exists, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     * @return Largest integer in the set.
     */
    public int largest() {
        if (set.isEmpty()) throw new RuntimeException("Set is empty");
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     * @return Smallest integer in the set.
     */
    public int smallest() {
        if (set.isEmpty()) throw new RuntimeException("Set is empty");
        return Collections.min(set);
    }

    /**
     * Adds a new element to the set if it's not already present.
     * @param item Element to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an element from the set if it exists.
     * @param item Element to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs the union of this set with another set.
     * @param intSetb The set to unite with.
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            add(num);
        }
    }

    /**
     * Performs the intersection of this set with another set.
     * @param intSetb The set to intersect with.
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Computes the difference of this set and another set (this set - other set).
     * @param intSetb The set to subtract.
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Computes the complement of this set relative to another set.
     * @param intSetb The universal set.
     */
    public void complement(IntegerSet intSetb) {
        set.clear();
        for (int num : intSetb.set) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }
    }

    /**
     * Checks if the set is empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * @return String format of the set.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}