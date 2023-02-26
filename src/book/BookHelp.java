package book;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static book.StudentProfile.*;

public class BookHelp {

    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<Book> record = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static Date issueDate;
    public static Date returnDate;


    public void booklog() {

        while (true) {

            int ch;
            System.out.println("\n***********************");
            System.out.print(" 1. Add Book \n 2. Display Book \n 3. Home Menu \n*********************** \n Enter Choice : ");
            ch = sc.nextInt();
            System.out.println("-----------------------");
            sc.nextLine();

            // Handle user input
            switch (ch) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    public void addBook() {

        String name,author;
        int id,numCopies,availability;

        System.out.print("Enter Id : ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Name : ");
        name = sc.nextLine();
        System.out.print("Enter Author Name : ");
        author = sc.nextLine();
        System.out.print("Enter Number of Copies: ");
        numCopies = sc.nextInt();

        System.out.println("User Must have to insert 0 or 1 for Availability ==>> 0 for not Available & 1 for Available ");
        System.out.print("Enter Availability of Book : ");
        availability = sc.nextInt();
        sc.nextLine();

        books.add(new Book(id, name, author, numCopies, availability));
    }


    public void displayBooks() {

        if(books.size()==0) {
            System.out.print("There's no Record of Book !!");
            return;
        }
        System.out.println("Book ID " + " | " + "Book Name" + " | " + " Book Author " + " | " + "Book Copies " + " | " +"Book Availability ");
        for (Book b : books) {
            System.out.println(b.getId() + " | " + b.getName() + " | " + b.getAuthor() + " | " + b.getNumCopies() + " | " + b.getAvailability());
        }
    }


    public static void issuelog() {

        while (true) {

            int ch;
            System.out.println("\n***********************");
            System.out.print(" 1. Issue Book \n 2. Return Book \n 3. Display Profile \n 4. Home \n*********************** \n Enter Choice : ");
            ch = sc.nextInt();
            System.out.println("-----------------------");
            sc.nextLine();


            // Handle user input
            switch (ch) {

                case 1:
                    issueBook();
                    break;

                case 2:
                    returnBook();
                    break;

                case 3:
                    stud_displayBooks();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }





//    public void returnBook(Books buybook,ArrayList<Books> totalBooks) {
//        ListIterator<Books> iterate = totalBooks.listIterator();
//        while (iterate.hasNext()) {
//            Books book = iterate.next();
//            if (book.bid == buybook.bid) {
//                iterate.next().copies++;
//                buybook.return_date = LocalDate.now();
//                long daysBetween = ChronoUnit.DAYS.between(buybook.issue_date, LocalDate.now().plusDays(25));
//                System.out.println("daysBetween" + daysBetween);
//                if (daysBetween > 15) {
//                    long fine_rs = (daysBetween - 15) * 5;
//                    System.out.println(fine_rs + "buybook");
//                    setFine(fine_rs);
//                }
//                this.issuedBooks.remove(buybook);
//                System.out.println("Transaction successful!");
//                System.out.println("-----------------------------------------------------------------------------------");
//                System.out.println(buybook.bname + " book has been returned");
//                return;
//            }
//        }
//    }






}