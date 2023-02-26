package book;

import java.time.LocalDate;

public class Book {

    public static LocalDate issueDate;
    public static LocalDate returnDate;
    public int id;
    public String name;
    public String author;
    public int numCopies;
    public int availability;

    public Book(int id, String name, String author, int numCopies, int availability) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.numCopies = numCopies;
        this.availability = availability;
    }

    public Book(int id, String name, String author, int numCopies, int availability, LocalDate issueDate, LocalDate returnDate) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.numCopies = numCopies;
        this.availability = availability;
        Book.issueDate = issueDate;
        Book.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public LocalDate getIssuedate() { return issueDate; }

    public LocalDate getReturndate() { return returnDate; }

    public String getName() {
        return name;
    }

    public static void setNumCopies(int numCopies) { numCopies = numCopies; }

    public String getAuthor() {
        return author;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public int getAvailability() {
        return availability;
    }

}