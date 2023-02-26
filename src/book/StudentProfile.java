package book;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static book.Book.issueDate;
import static book.Book.returnDate;

public class StudentProfile extends BookHelp{

    public static void issueBook() {

        System.out.print("Enter Book Id : ");
        int bid = sc.nextInt();
        int t = 0;

        for (int i = 0; i < books.size(); i++) {

            if (bid == BookHelp.books.get(i).id && BookHelp.books.get(i).availability == 1) {

                t = 1;

                issueDate = LocalDate.now();    // set issue date to current date
                returnDate = LocalDate.now().plusDays(20);

                record.add(new Book(bid, BookHelp.books.get(i).name, BookHelp.books.get(i).author, BookHelp.books.get(i).numCopies, BookHelp.books.get(i).availability, issueDate, returnDate));
                Book.setNumCopies(--BookHelp.books.get(i).numCopies);

                System.out.println("\n===============================");
                System.out.println("Book Issued Successfully !!");
                System.out.println("===============================");
            }
        }
        if(t == 0){
            System.out.println("\n===============================");
            System.out.println("This Book is Not available !!");
            System.out.println("===============================");
        }
    }

    public static void returnBook() {

        stud_displayBooks();
        int t = 0;

        System.out.print("\nEnter Return Book Id : ");
        int rtid = sc.nextInt();

        for (int i = 0; i < record.size(); i++) {

            if (rtid == record.get(i).id) {

                Book.setNumCopies(++record.get(i).numCopies);
                System.out.println("\n===============================");
                System.out.println("Book Returned Successfully !!");
                System.out.println("===============================");


                long daysBetween = ChronoUnit.DAYS.between(BookHelp.record.get(i).issueDate, BookHelp.record.get(i).returnDate);
                System.out.println("Issue Date = "+record.get(i).issueDate);
                System.out.println("Return Date = "+record.get(i).getReturndate());
                System.out.println("\nTotal Days = " + daysBetween);

                if (daysBetween > 15) {
                    long fine_rs = (daysBetween - 15) * 5;
                    System.out.println("Fine for overdue = "+fine_rs+" Ruppes");
                }
                record.remove(BookHelp.record.get(i));
            }
            t = 1;
        }
        if(t == 0){
            System.out.println("\n===============================");
            System.out.println("There's no book in Catalog");
            System.out.println("===============================");
        }
    }

    public static void stud_displayBooks() {

        if(record.size()==0) {
            System.out.println("\n===============================");
            System.out.println("There's no Record of Book !!");
            System.out.println("===============================");

            return;
        }
        //System.out.printf("%-10d %-30s %-10d %-10d %-20s%n",bid,bname,bpoints,copies,avail);
        System.out.println("Book ID " + " | \t" + "Book Name" + " | \t" + " Book Author " + " | \t" + "Book Copies \t" + " | \t" +"Book Availability " + " | \t" + "Book issue date" + " | \t" + "Book return date");
        for (Book r : record) {
            System.out.printf(r.getId() + " | \t\t" + r.getName() + " | \t\t" + r.getAuthor() + " | \t\t" + r.getNumCopies() + " | \t\t\t" + r.getAvailability() + " | \t\t\t" + issueDate + " | \t\t\t" + returnDate + "\n");
        }
    }
}