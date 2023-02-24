import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    Scanner sc = new Scanner(System.in);
    Console cl = System.console();
    char [] temp = new char[0];

    //Create ArrayLists Global for username, fullname and password
    ArrayList<String> student_username = new ArrayList<>();
    ArrayList<String> student_fullname = new ArrayList<>();
    ArrayList<String> student_password = new ArrayList<>();


    public void reg_student() {

        int flag1 = 0;

        if(flag1 == 0) {

            while (true) {

                System.out.print("Enter Full Name : ");
                String temp = sc.nextLine();

                int char_count = 0;
                int space_count = 0;

                // Validation of Full name
                for (int i = 0; i < temp.length(); i++) {

                    if (temp.charAt(i) >= 'A' && temp.charAt(i) <= 'Z' || temp.charAt(i) >= 'a' && temp.charAt(i) <= 'z')
                        char_count++;

                    else if (temp.charAt(i) == ' ')
                        space_count++;
                }

                int flag = 0;

                if (char_count >= 6 && space_count == 2) {

                    student_fullname.add(temp);
                    flag = 1;
                    break;
                }
                if (flag == 0) {

                    System.out.println("\n==================================================================================");
                    System.out.println("Full Name contains Firstname, Middle name and Lastname each of two character !!");
                    System.out.println("==================================================================================");
                }
            }


            System.out.print("Enter Username : ");
            student_username.add(sc.nextLine());

            while (true) {

                System.out.print("Enter Password : ");
                temp = cl.readPassword();
                System.out.println("***********************");

                String pass = new String(temp);

                int digit_count = 0;
                int capital_char_count = 0;
                int small_char_count = 0;
                int special_char_count = 0;

                //Validation of Password
                for (int i = 0; i < pass.length(); i++) {

                    if (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z')
                        capital_char_count++;

                    else if(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z')
                        small_char_count++;

                    else if (pass.charAt(i) >= '0' && pass.charAt(i) <= '9')
                        digit_count++;

                    else
                        special_char_count++;

                }

                int length = capital_char_count + small_char_count + digit_count + special_char_count;
                int flag = 0;

                if (capital_char_count >= 1 && small_char_count >= 1 && digit_count >= 1 && special_char_count >= 1 && length >= 6 && length <= 15) {

                    student_password.add(pass);
                    flag = 1;
                    break;
                }

                if (flag == 0) {
                    System.out.println("\n================================================================================================================================================");
                    System.out.println("Password must contain at least one digit and at least one small letter, capital letter,special character And length should be between 6 to 15 !!");
                    System.out.println("================================================================================================================================================");
                }
            }
            System.out.println("\n=======================");
            System.out.println("User Successfully Registered ");
            System.out.println("=======================\n");
            flag1 = 1;

        }

        else {
            System.out.println("\n=======================");
            System.out.println("One User Already Registered, You can not Register !");
            System.out.println("=======================");
        }
    }



    public void studlog() {

        String un;
        int ch;
        char[] si = new char[0];
        char[] temp;
        boolean flag = true;
        String usname;

        while (true) {

            System.out.println("\n***********************");
            System.out.print(" 1.LogIn \n 2.Forget Password \n 3.Home Menu \n*********************** \n Enter Choice : ");
            ch = sc.nextInt();
            System.out.println("-----------------------");
            sc.nextLine();

            switch (ch) {

                case 1:

                    try {

                        System.out.println("\n***********************");
                        System.out.print("Enter Username : ");
                        un = sc.nextLine();

                        int y = 0;

                        for (int i = 0; i < student_username.size(); i++) {

                            if (student_username.get(i).equals(un)) {

                                System.out.print("Enter Password : ");
                                si = cl.readPassword();
                                System.out.println("***********************");
                                y = 1;
                            }
                        }

                        if (y == 0) {

                            System.out.println("\n==========================");
                            System.out.println("Invalid Username");
                            System.out.println("==========================");
                            break;
                        }

                        int t = 0;

                        for (int i = 0; i < student_username.size(); i++) {

                            if (student_username.get(i).equals(un) && student_password.get(i).equals(new String(si))) {

                                t = 1;

                                System.out.println("\n==========================");
                                System.out.println("User Successfully login");
                                System.out.println("==========================\n");
                            }

                        }

                        if (t == 0) {
                            System.out.println("\n==========================");
                            System.out.println("Invalid password");
                            System.out.println("==========================");
                        }
                    } catch (Exception e) {

                        System.out.println("\n==========================");
                        System.out.println("Login Error " + e);
                        System.out.println("==========================");
                    }
                    break;

                case 2:

                    int p = 0;
                    System.out.println("\n***********************");
                    System.out.print("Enter Username : ");
                    usname = sc.nextLine();

                    for (int i = 0; i < student_username.size(); i++) {

                        if (student_username.get(i).equals(usname))
                            p = 1;
                    }

                    if (p == 0) {

                        System.out.println("\n==========================");
                        System.out.println("Invalid Username");
                        System.out.println("==========================");
                    }

                    for (int i = 0; i < student_username.size(); i++) {

                        if (student_username.get(i).equals(usname)) {

                            while (true) {

                                System.out.print("Enter New Password : ");
                                temp = cl.readPassword();

                                int digit_count = 0;
                                int capital_char_count = 0;
                                int small_char_count = 0;
                                int special_char_count = 0;

                                for (int j = 0; j < (new String(temp)).length(); j++) {

                                    if ((new String(temp)).charAt(j) >= 'A' && (new String(temp)).charAt(j) <= 'Z')
                                        capital_char_count++;

                                    else if ((new String(temp)).charAt(j) >= 'a' && (new String(temp)).charAt(j) <= 'z')
                                        small_char_count++;

                                    else if ((new String(temp)).charAt(j) >= '0' && (new String(temp)).charAt(j) <= '9')
                                        digit_count++;

                                    else
                                        special_char_count++;

                                }

                                int length = capital_char_count + small_char_count + digit_count + special_char_count;
                                int f = 0;

                                if (capital_char_count >= 1 && small_char_count >= 1 && digit_count >= 1 && special_char_count >= 1 && length >= 6 && length <= 15) {

                                    student_password.set(i, (new String(temp)));
                                    f = 1;
                                    break;
                                }

                                if (f == 0)
                                    System.out.println("Password must contain atleast one digit and at least one small, capital,special character And length should be between 6 to 10!! \n");

                            }
                            System.out.println("\n===============================");
                            System.out.println("Password Changed Successfully !! ");
                            System.out.println("===============================");
                        }
                    }
                    break;

                case 3:
                    return;

                default:
                    System.out.println("\n==========================");
                    System.out.println("Invalid Input");
                    System.out.println("\n==========================");

            }
        }
    }



    public void student_forget() {

        int p = 0;
        System.out.println("\n***********************");
        System.out.print("Enter Username : ");
        String usname = sc.nextLine();

        for (int i = 0; i < student_username.size(); i++) {

            if(student_username.get(i).equals(usname))
                p = 1;
        }

        if(p == 0) {

            System.out.println("\n==========================");
            System.out.println("Invalid Username");
            System.out.println("==========================");
        }

        for (int i = 0; i < student_username.size(); i++) {

            if (student_username.get(i).equals(usname)) {

                while (true) {

                    System.out.print("Enter New Password : ");
                    temp = cl.readPassword();

                    String pass = new String(temp);

                    int digit_count = 0;
                    int capital_char_count = 0;
                    int small_char_count = 0;
                    int special_char_count = 0;

                    for (int j = 0; j < (new String(temp)).length(); j++) {

                        if (pass.charAt(j) >= 'A' && pass.charAt(j) <= 'Z')
                            capital_char_count++;

                        else if(pass.charAt(j) >= 'a' && pass.charAt(j) <= 'z')
                            small_char_count++;

                        else if (pass.charAt(j) >= '0' && pass.charAt(j) <= '9')
                            digit_count++;

                        else
                            special_char_count++;

                    }

                    int length = capital_char_count + small_char_count + digit_count + special_char_count;
                    int f = 0;

                    if (capital_char_count >= 1 && small_char_count >= 1 && digit_count >= 1 && special_char_count >= 1 && length >= 6 && length <= 15) {

                        student_password.set(i, pass);
                        f = 1;
                        break;
                    }

                    if (f == 0)
                        System.out.println("Password must contain atleast one digit and at least one small, capital,special character And length should be between 6 to 15!! \n");

                }
                System.out.println("\n===============================");
                System.out.println("Password Changed Successfully !! ");
                System.out.println("===============================");
            }
        }
    }

}
