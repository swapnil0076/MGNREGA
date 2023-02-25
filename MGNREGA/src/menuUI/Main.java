package menuUI;

import Custom_Colors.Colors;
import DAO_USECASES.BDO_UseCases;

import java.util.Scanner;

import DAO_USECASES.GPMember_UseCases;
import Exception.*;


public class Main {

    private static BDO_UseCases bdo_useCases;
    private static GPMember_UseCases gpMember_useCases;


    static void displayAdminMenu() {
        System.out.println();
        System.out.println();
        System.out.println(Colors.YELLOW_BOLD+Colors.YELLOW_BRIGHT+"╭══• ೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋ •══╮");
        System.out.println("     1. Create a project.");
        System.out.println("     2. View List Of Project");
        System.out.println("     3. Create new Gram Panchayat Member(GPM).");
        System.out.println("     4. View all the GPM.");
        System.out.println("     5. Allocate Project to GPM");
        System.out.println("     6. See List of Employee working on that Project and their wages.");
        System.out.println("     7. View the Unallocated Projects");

        System.out.println("     0. for Exit");
        System.out.println("╰══• ೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋ•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋ•ೋೋ•✧๑๑✧• •══╯");
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
                    gpMember_useCases.WorkingProjectWage_UseCase();
                    break;
                case 7:
                    bdo_useCases.RemainProject_UseCase();
                    break;

                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
    }

static void Gram_Panchayat_member(Scanner s) throws GPMember_Exception, ProjectException, Employee_Exception {
    if(gpMember_useCases.GPMemberLogin_UseCases()){
        GPMember_Menu(s);
    }else{
        System.out.println("Invalid Username and Password");
    }
}

    static void displayGPMember_Menu(){
        System.out.println();
        System.out.println();
        System.out.println(Colors.YELLOW_BOLD+Colors.YELLOW_BRIGHT+"╭══• ೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋ •══╮");
        System.out.println("     1. Create Employee.");
        System.out.println("     2. View the Details of Employee.");
        System.out.println("     3. Assign Employee to a Project.");
        System.out.println("     4. Allocate Project to GPM");
        System.out.println("     5. View total number of days Employee worked in a project and also their wages");
        System.out.println("     6. Update the Status of Project");
        System.out.println("     7. View All the Project");
        System.out.println("     0. for Exit");
        System.out.println("╰══• ೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋ •══╯");
    }

static void  GPMember_Menu(Scanner sc) throws Employee_Exception, ProjectException {

    int choice = 0;
    do {
        displayGPMember_Menu();
        System.out.print("Enter selection ");
        choice = sc.nextInt();
        switch(choice) {
            case 0:
                System.out.println("Bye Bye admin");
                break;
            case 1:
              gpMember_useCases.addNewEmployee_UseCase();
                break;
            case 2:
                gpMember_useCases.viewEmployee_UseCases();
                break;
            case 3:
                gpMember_useCases.assignEmployeeToProject_UseCase();
                break;
            case 4:
                gpMember_useCases.addTheDailyWage();
                break;
            case 5:
               gpMember_useCases.viewTotalNoDays();
                break;

            case 6:
                gpMember_useCases.ChangeStatus_UseCase();
                break;
            case 7:
               bdo_useCases.viewAllProjectUseCase();
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
        System.out.println(Colors.RED +"»»————->　Welcome Vinayak BDO (Block Development Officer)　<————-««"+Colors.RESET);
        adminMenu(sc);
    }else {
        System.out.println("Invalid Username and Password");
    }

}

    public static void main(String[] args) throws ProjectException, GPMember_Exception, Employee_Exception {

        Scanner s = new Scanner(System.in);

        System.out.println(Colors.YELLOW_BOLD+Colors.YELLOW_BRIGHT+"       ▂▃▄▅▆▇█▓▒░       WELCOME      ░▒▓█▇▆▅▄▃▂");
        System.out.println();

        int choice = 0;
        do {
            System.out.println("╭══• ೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋ •══╮");
            System.out.println("     1.  BDO (Block Development Officer) Login\n     2. Gram Panchayat member Login\n     0. Exit");
            System.out.println("╰══• ೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋೋ•✧๑๑✧•ೋ •══╯");
            choice = s.nextInt();
            switch(choice) {
                case 0:
                    System.out.println("Thank you, Visit again");
                    break;
                case 1:
                    Block_Development_Officer(s);
                    break;
                case 2:
                    Gram_Panchayat_member(s);
                    break;
                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
        s.close();
    }



}
