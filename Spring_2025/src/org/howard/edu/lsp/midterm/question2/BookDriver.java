package org.howard.edu.lsp.midterm.question2;

/**
 * Will test the functionality of the Book class with book objects
 * 
 * @author David Mack
 */
public class BookDriver {
    /**
     * start of program
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Creating Book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Testing equals() method
        System.out.println(book1.equals(book2)); //true
        System.out.println(book1.equals(book3)); //false

        // Testing toString() method
        System.out.println(book1);
    }
}
