package DAO_USECASES;

import BeanClass.GPMember;
import BeanClass.Project;
import DAO.ProjectDAO_Impl;
import DAO.Project_DAO;
import Exception.*;
import java.util.List;
import java.util.Scanner;



public class BDO_UseCases {



    public static void addProject_UseCase() throws ProjectException {

        Scanner s = new Scanner(System.in);
        Project_DAO pdao = new ProjectDAO_Impl();

        System.out.println("Enter the Project Name");
        String name = s.next();

        System.out.println("Enter the Project Address");
        String add = s.next();

        System.out.println("Enter the Project Panchayat Id");
        int pan_Id = s.nextInt();

        System.out.println("Enter the Project Budget");
        int bud = s.nextInt();

        System.out.println("Enter the Project Location");
        String loc = s.next();

        String mess =   pdao.addNewProject(new Project(name,add,pan_Id,bud,loc));


        System.out.println(mess);

    }

    public static void viewAllProjectUseCase() throws ProjectException {

        Project_DAO pdo = new ProjectDAO_Impl();

        List<Project> pro = pdo.viewAllProject();


            pro.forEach(System.out::println);







    }

    public static void addGPM_USECASE() throws GPMember_Exception {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the Gram Panchayat Member(GPM) Name");
        String name = s.next();

        System.out.println("Enter the Gram Panchayat Member(GPM) Address");
        String add = s.next();


        System.out.println("Enter the Gram Panchayat Member(GPM) Password");
        String pass = s.next();

        System.out.println("Select the Gram Panchayat from the following :- ");
        System.out.println("+------------------+-----------------------+------------------------------+\n" +
                "| gram_panchayat_Id | gram_panchayat_Address | gram_panchayat_name          |\n" +
                "+------------------+-----------------------+------------------------------+\n" +
                "|                1 |                   123 | Example Gram Panchayat       |\n" +
                "|                2 |                   456 | Greenfield Gram Panchayat    |\n" +
                "|                3 |                   789 | Rural ville Gram Panchayat   |\n" +
                "|                4 |                   321 | Meadow dale Gram Panchayat   |\n" +
                "|                5 |                   654 | Sunset Valley Gram Panchayat |\n" +
                "|                6 |                   987 | Hometown Gram Panchayat      |\n" +
                "+------------------+-----------------------+------------------------------+ ");

        int x = s.nextInt();

        Project_DAO pdao = new ProjectDAO_Impl();
        String mess =  pdao.AddGPM(new GPMember(name,add,pass,x));
        System.out.println(mess);



    }

    public static void viewAllGPMember_UseCase() throws GPMember_Exception {

        Project_DAO dao = new ProjectDAO_Impl();

        List<GPMember> list = dao.viewAllGPMember();

        list.forEach(System.out::println);


    }

    public static void allocateTheporject() throws ProjectException, GPMember_Exception {


        RemainProject_UseCase();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the id of Project");
        int j = s.nextInt();





        Project_DAO pd = new ProjectDAO_Impl();


         List<GPMember> list = pd.seTheGPMemberUnder(j);


        list.forEach(e -> System.out.println("Id of Gram Panchayat Member --> "+e.getGP_member_Id()+"\n"+"Name of Gram Panchayat Member  --> "+e.getGP_member_Name()));
        allocateTheporject_UseCase();
    }

    public static void allocateTheporject_UseCase() throws ProjectException, GPMember_Exception {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the Id of Gram Panchayat Member");
        int x = s.nextInt();

        System.out.println("Enter the id of Project");
        int j = s.nextInt();

        Project_DAO pdao = new ProjectDAO_Impl();
        String mess = pdao.allocateTheProject(x,j);

        System.out.println(mess);

    }

    public static void RemainProject_UseCase() throws ProjectException {

        Project_DAO pdao = new ProjectDAO_Impl();

        List<Project> pro = pdao.seeTheRemainProject();

        pro.forEach(System.out::println);

    }



}
