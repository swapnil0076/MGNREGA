package DAO_USECASES;

import BeanClass.Employee;
import BeanClass.Project;
import BeanClass.Wage;
import Custom_Colors.Colors;
import DAO.GPMemberDAO_Impl;
import DAO.GPMember_DAO;
import DAO.ProjectDAO_Impl;
import DAO.Project_DAO;
import Exception.*;

import java.util.List;
import java.util.Scanner;

public class GPMember_UseCases {

    public static boolean GPMemberLogin_UseCases() throws GPMember_Exception {



        Scanner s = new Scanner(System.in);

        System.out.println("Enter the ID");
        int x = s.nextInt();

        System.out.println("Enter the Password");
       int pass = s.nextInt();

        GPMember_DAO gpd = new GPMemberDAO_Impl();

        boolean mess = gpd.LoginAsGPMember(x,pass);

        if(mess){

            return mess;
        }else{
            return false;
        }

    }

    public static void addNewEmployee_UseCase() throws Employee_Exception {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the Employee Name");
        String na = s.next();

        System.out.println("Enter the Employee Address");
        String add = s.next();

        System.out.println("Enter the Employee Panchayat Id");
        int x = s.nextInt();

        GPMember_DAO gpd = new GPMemberDAO_Impl();
        String mess = gpd.addEmployee(new Employee(na,add,x));

        System.out.println(mess);


    }

    public static void viewEmployee_UseCases() throws Employee_Exception {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the panchayat Id");
        int p = s.nextInt();

        GPMember_DAO gpd = new GPMemberDAO_Impl();

        List<Employee> empd = gpd.ViewEmployee(p);

        empd.forEach(System.out::println);

    }

    public static void assignEmployeeToProject_UseCase() throws ProjectException, Employee_Exception {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the Employee ID");
        int em = s.nextInt();

        System.out.println("Enter the project Id");
        int i = s.nextInt();

        GPMember_DAO gmpd = new GPMemberDAO_Impl();
       String mess =  gmpd.assignEmployee(em,i);

        System.out.println(mess);

    }

    public static void addTheDailyWage() throws Employee_Exception {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the Employee Id");
        int empId  = s.nextInt();

        System.out.println("Enter the Project Id");
        int nt = s.nextInt();

        System.out.println("Enter the Gram Panchayat Id");
        int t = s.nextInt();

        System.out.println("Enter the Daily Wage");
        int am = s.nextInt();

        GPMember_DAO geo = new GPMemberDAO_Impl();
        String mess = geo.employeeAttendence(new Wage(empId,nt,t,am));

        System.out.println(mess);
    }

    public static void viewTotalNoDays() throws Employee_Exception {

        Scanner s = new Scanner(System.in);

        System.out.println(Colors.GREEN +"Enter the Employee ID");
        int m = s.nextInt();
        GPMember_DAO gdo = new GPMemberDAO_Impl();

       String mess =  gdo.noOfDaysEmployee(m);

        System.out.println(mess);

    }

    public static void ChangeStatus_UseCase() throws ProjectException {

        Scanner s = new Scanner(System.in);



        System.out.println("Enter the Project Id");
        int x = s.nextInt();

        System.out.println("Select the Status");
        System.out.println();
        System.out.println("1. In Progress");
        System.out.println("2. Completed");

        String mess = "";
        int choice = s.nextInt();

        if(choice == 1){
            mess = "In Progress";
        } else if (choice == 2) {
            mess = "Completed";
        }else{
            throw new ProjectException("Choose the correct");
        }

        GPMember_DAO gpd = new GPMemberDAO_Impl();
       String med =  gpd.ChangeStatusofProject(x,mess);

        System.out.println(med);

    }

    public static void WorkingProjectWage_UseCase() throws ProjectException {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the project Id");
        int x = s.nextInt();

        Project_DAO pdao = new ProjectDAO_Impl();

        List<Project> pdm = pdao.employeeWorkingProject(x);

        pdm.forEach(e -> System.out.println("╔═══════════════════════════╗\n"+"Project id -"+e.getProjectId()+"\n"+"Project Name -"+e.getProjectName()+"\n"+
                "Status -"+e.getStatus()+"\n"+"Wages Amount -"+e.getWage()
               +"\n"+
                "╚════════════════════════════╝" ));



    }

}
