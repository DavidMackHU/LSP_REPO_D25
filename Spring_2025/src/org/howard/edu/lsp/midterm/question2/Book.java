package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a singular book
 * track all book information
 * Needs to override the equals() and toString() methods
 * 
 * @author David Mack
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructs a new Book object with the specified details.
     * 
     * @param title         The title of the book.
     * @param author        The author of the book.
     * @param ISBN          The ISBN number of the book (unique identifier).
     * @param yearPublished The year the book was published.
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    /**
     * Gets the title of the book.
     * 
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     * 
     * @param title The new title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     * 
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     * 
     * @param author The new author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     * 
     * @return The ISBN of the book.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the ISBN of the book.
     * 
     * @param ISBN The new ISBN of the book.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Gets the year the book was published.
     * 
     * @return The year of publication.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published.
     * 
     * @param yearPublished The new publication year.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Checks if two Book objects are equal based on ISBN and author.
     * 
     * @param obj The object to compare with.
     * @return true if the books have the same ISBN and author, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // If both objects refer to the same instance
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Check if obj is null or of a different class
        }
        Book book = (Book) obj;
        return this.ISBN.equals(book.ISBN) && this.author.equals(book.author);
    }

    /**
     * Returns a string representation of the Book object.
     * 
     * @return A formatted string containing book details.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
