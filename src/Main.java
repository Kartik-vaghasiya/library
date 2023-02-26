import java.util.Scanner;

public class Main {
    static User st = new User();        //Global Object of User Class
    static Admin ad = new Admin();      //Global Object of Admin Class
    static Scanner sc = new Scanner(System.in);        //Global Object of Scanner Class


    public static void main(String[] args) {
// main method
        try{
            while (true) {

                int ch = 0;
                System.out.println("\n---------Menu---------");
                System.out.print(" 1. LogIn \n 2. Register \n 3. Exit \n---------------------- \n Enter Choice : ");
                ch = sc.nextInt();
                System.out.println("***********************");

                switch (ch) {

                    case 1:

                        login();     //Method calling of SignIn Class with parameter of Register class Object
                        break;

                    case 2:
                        register();       //Method calling of Register Class
                        break;

                    case 3:
                        System.exit(0);     //Method for Exit or Terminate Program
                        break;

                    default:
                        System.out.println("Invalid Input !!");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error !!" +e);
        }
    }

    //registration method
    public static void register() {

        try{
            while (true) {

                int ch = 0;
                System.out.println("\n---------Menu---------");
                System.out.print(" 1. Admin \n 2. Student \n 3. Home \n---------------------- \n Enter Choice : ");
                ch = sc.nextInt();
                System.out.println("***********************");

                switch (ch) {

                    case 1:

                        ad.reg_admin();
                        return;

                    case 2:
                        st.reg_student();
                        return;

                    case 3:
                        return;

                    default:
                        System.out.println("Invalid Input !!");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error !!" +e);
        }
    }

    // login method for admin and student.....
    public static void login() {

        try{
            while (true) {

                int ch = 0;
                System.out.println("\n---------Menu---------");
                System.out.print(" 1. Admin \n 2. Student \n---------------------- \n Enter Choice : ");
                ch = sc.nextInt();
                System.out.println("***********************");

                switch (ch) {

                    case 1:

                        while(true) {

                            int ans = 0;
                            System.out.println("\n---------Menu---------");
                            System.out.print(" 1. LogIn \n 2. Forget Password \n 3. Home \n---------------------- \n Enter Choice : ");
                            ans = sc.nextInt();
                            System.out.println("***********************");

                            switch(ans) {

                                case 1:
                                    ad.adminlog();
                                    return;

                                case 2:
                                    ad.admin_forget();
                                    return;

                                case 3:
                                    return;

                                default:
                                    System.out.println("Invalid Input !!");
                            }
                        }

                    case 2:

                        while(true) {

                            int res = 0;
                            System.out.println("\n---------Menu---------");
                            System.out.print(" 1. LogIn \n 2. Forget Password \n 3. Home \n---------------------- \n Enter Choice : ");
                            res = sc.nextInt();
                            System.out.println("***********************");

                            switch(res) {

                                case 1:
                                    st.studlog();
                                    return;

                                case 2:
                                    st.student_forget();
                                    return;

                                case 3:
                                    return;

                                default:
                                    System.out.println("Invalid Input !!");
                            }
                        }

                    case 3:
                        return;

                    default:
                        System.out.println("Invalid Input !!");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error !!" +e);
        }
    }
}