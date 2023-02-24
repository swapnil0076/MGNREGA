package menuUI;

import Custom_Colors.Colors;
import DAO_USECASES.BDO_UseCases;

import java.util.Scanner;
import Exception.*;


public class Main {

    private static BDO_UseCases bdo_useCases;


    static void displayAdminMenu() {
        System.out.println("1. Create a project.");
        System.out.println("2. View List Of Project");
        System.out.println("3. Create new Gram Panchayat Member(GPM).");
        System.out.println("4. View all the GPM.");
        System.out.println("5. Allocate Project to GPM");
        System.out.println("6. See List of Employee working on that Project and their wages.");
        System.out.println("0. for Exit");
    }

    static void adminMenu(Scanner sc) throws ProjectException, GPMember_Exception {
        int choice = 0;
        do {
            displayAdminMenu();
            System.out.print("Enter selection ");
            choice = sc.nextInt();
            switch(choice) {
                case 0:
                    System.out.println("Bye Bye admin");
                    break;
                case 1:
                    bdo_useCases.addProject_UseCase();
                    break;
                case 2:
                    bdo_useCases.viewAllProjectUseCase();
                    break;
                case 3:
                    bdo_useCases.addGPM_USECASE();
                    break;
                case 4:
                    bdo_useCases.viewAllGPMember_UseCase();
                    break;
                case 5:
                    bdo_useCases.allocateTheporject();
                    break;
                case 6:

                    break;

                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
    }




static void Block_Development_Officer(Scanner sc) throws ProjectException, GPMember_Exception {

    System.out.print("Enter username ");
    String username = sc.next();
    System.out.print("Enter password ");
    String password = sc.next();

    if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
        System.out.println(Colors.RED +"Welcome Vinayak BDO (Block Development Officer)"+Colors.RESET);
        adminMenu(sc);
    }else {
        System.out.println("Invalid Username and Password");
    }

}

    public static void main(String[] args) throws ProjectException, GPMember_Exception {

        Scanner s = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("1.  BDO (Block Development Officer) Login\n2. Gram Panchayat member Login\n0. Exit");
            choice = s.nextInt();
            switch(choice) {
                case 0:
                    System.out.println("Thank you, Visit again");
                    break;
                case 1:
                    Block_Development_Officer(s);
                    break;
                case 2:

                    break;
                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
        s.close();
    }



}
