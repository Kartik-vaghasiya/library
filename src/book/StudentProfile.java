package book;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StudentProfile extends BookHelp{


    // Define the late fee fine per day in Rupee
    private static final double LATE_FEE_FINE_PER_DAY = 5;
    public static void issueBook() {

        System.out.print("Enter Book Id : ");
        int bid = sc.nextInt();
        int t = 0;

        for (int i = 0; i < books.size(); i++) {

            if (bid == BookHelp.books.get(i).id && BookHelp.books.get(i).availability == 1) {

                t = 1;
                issueDate = new Date();    // set issue date to current date
                returnDate = new Date(issueDate.getTime() + 15 * 24 * 60 * 60 * 1000); // set return date 15 days in the future

                record.add(new Book(bid, BookHelp.books.get(i).name, BookHelp.books.get(i).author, BookHelp.books.get(i).numCopies, BookHelp.books.get(i).availability, issueDate, returnDate));
                Book.setNumCopies(--BookHelp.books.get(i).numCopies);

                System.out.println("\nBook Issued Successfully !!");
            }
        }
        if(t == 0){
            System.out.println("\nThis Book is Not available !!");
        }
    }

    public static void returnBook() {

        stud_displayBooks();
        int t = 0;

        System.out.print("\nEnter Return Book Id : ");
        int rtid = sc.nextInt();

        for (int i = 0; i < record.size(); i++) {

            if (rtid == BookHelp.record.get(i).id) {

                Book.setNumCopies(++BookHelp.record.get(i).numCopies);
                record.remove(BookHelp.record.get(i));
                System.out.println("\nBook Returned Successfully !!");
                t = 1;

                long difference = returnDate.getTime() - issueDate.getTime();
                long differenceInDays = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);

                if(differenceInDays > 15) {
                    // Calculate the late fee fine
                    double lateFeeFine = differenceInDays * LATE_FEE_FINE_PER_DAY;

                    // Print the late fee fine
                    System.out.println("\nThe late fee fine for this book is = " +lateFeeFine);
                }
            }
        }
        if(t == 0){
            System.out.println("\nThere's no book in Catalog");
        }
    }

    public static void stud_displayBooks() {

        if(record.size()==0) {
            System.out.print("There's no Record of Book !!");
            return;
        }
        System.out.println("Book ID " + " | " + "Book Name" + " | " + " Book Author " + " | " + "Book Copies " + " | " +"Book Availability " + " | " + "Book issue date" + " | " + "Book return date");
        for (Book r : record) {
            System.out.println(r.getId() + " | \t\t" + r.getName() + " | \t\t" + r.getAuthor() + " | \t\t" + r.getNumCopies() + " | \t\t" + r.getAvailability() + " | \t\t" + issueDate + " | \t\t" + returnDate + "\n");
        }
    }
}