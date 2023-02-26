package book;

import java.util.Date;

public class Book {

    public  Date issuedate;
    public  Date returndate;
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

    public Book(int id, String name, String author, int numCopies, int availability, Date issueDate, Date returnDate) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.numCopies = numCopies;
        this.availability = availability;
        this.issuedate = issueDate;
        this.returndate = returnDate;
    }

    public int getId() {
        return id;
    }

    public Date getIssuedate() { return issuedate; }

    public Date getReturndate() { return returndate; }

    public String getName() {
        return name;
    }

    //public void setIssuedate(Date issuedate) { this.issuedate = issuedate; }

    //public void setReturndate(Date returndate) { this.returndate = returndate; }

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