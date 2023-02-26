package DAO;

import BeanClass.GPMember;
import BeanClass.Project;
import Exception.*;
import Utility.dbutilities;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectDAO_Impl implements Project_DAO{
    @Override
    public String addNewProject(Project project) throws ProjectException {
        String mess = "Failed to Add the Project";

        try (Connection con = dbutilities.getConnection()){
            String query = "Insert into project(projectName,projectAddress,gram_panchayat_Id,budget,location) values (?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,project.getProjectName());
            ps.setString(2,project.getProjectAddress());
            ps.setInt(3,project.getGram_panchayat_Id());
            ps.setInt(4,project.getBudget());
            ps.setString(5,project.getLocation());

            int x = ps.executeUpdate();
            if(x>0){
                mess = "Project Added Successfully";
            }else{
                throw new ProjectException("Check the Details Again");
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }

        return mess;
    }

    @Override
    public List<Project> viewAllProject() throws ProjectException {
        List<Project> project = new ArrayList<>();

        try(Connection con = dbutilities.getConnection()) {

            PreparedStatement ps = con.prepareStatement("select * from project");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int x = rs.getInt("projectId");
                String na = rs.getString("projectName");
                String add = rs.getString("projectAddress");
                int gp_Id = rs.getInt("gram_panchayat_Id");
                int gpm_Id = rs.getInt("GP_member_Id");
                int budget = rs.getInt("budget");
                LocalDate start = rs.getDate("start").toLocalDate();
               Date end = rs.getDate("end");

                LocalDate localEndDate = null;
                if (end != null) {
                    localEndDate = end.toLocalDate();
                }

                String loc = rs.getString("location");
                String status = rs.getString("status");

                Project project1 = new Project(x,na,add,gp_Id,gpm_Id,budget,start,localEndDate,loc,status);

                project.add(project1);

            }


        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }

        return project;

    }

    @Override
    public String AddGPM(GPMember gpMember) throws GPMember_Exception {

        String mess = "Failed to Add Gram Panchayat Member(GPM)";

        try(Connection con = dbutilities.getConnection()) {

            String quarry = "insert into Gram_panchayat_member(GP_member_Name,GP_member_Address,GP_member_Password,gram_panchayat_Id) values(?,?,?,?);";

            PreparedStatement ps = con.prepareStatement(quarry);
            ps.setString(1,gpMember.getGP_member_Name());
            ps.setString(2, gpMember.getGP_member_Address());
            ps.setString(3, gpMember.getGP_member_Password());
            ps.setInt(4,gpMember.getGram_panchayat_Id());

            int x = ps.executeUpdate();

            if(x>0){
                mess = "Add Gram Panchayat Member(GPM) Successfully";
            }else{
                throw  new GPMember_Exception("Check the Details of Employee");
            }

        } catch (SQLException e) {
            e.getMessage();
           e.printStackTrace();
        }


        return mess;
    }

    @Override
    public List<GPMember> viewAllGPMember() throws GPMember_Exception {
        List<GPMember> list = new ArrayList<>();

        try(Connection con = dbutilities.getConnection()) {

            String query = "select * from gram_panchayat_member";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int x = rs.getInt("GP_member_Id");
                String str = rs.getString("GP_member_Name");
                String add = rs.getString("GP_member_Address");
                int gm_id = rs.getInt("gram_panchayat_Id");

                GPMember gpm = new GPMember(x,str,add,gm_id);

                list.add(gpm);

            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

        return list;
    }

    @Override
    public String allocateTheProject(int gram_Member,int projectId) throws ProjectException,GPMember_Exception {

        String mess = "Failed to Allocate the Project to Gram Panchayat Member";

        try(Connection con = dbutilities.getConnection()) {

            String quarry = "Update project set GP_member_Id  = ? where projectId = ? ";

            PreparedStatement ps = con.prepareStatement(quarry);

            ps.setInt(1,gram_Member);
            ps.setInt(2,projectId);

            int x = ps.executeUpdate();

            if(x>0){
                mess = "Allocate the Project to Gram Panchayat Member Successfully";
            }else{
                throw new GPMember_Exception("Member not found with that ID");
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }

        return mess;
    }

    @Override
    public List<GPMember> seTheGPMemberUnder(int projecId) throws GPMember_Exception {

        List<GPMember> gp = new ArrayList<>();

        try(Connection con = dbutilities.getConnection()) {

            String quarry = "select g.GP_member_Id,g.GP_member_Name from Gram_panchayat_member g \n" +
                    "inner join project p on g.gram_panchayat_Id = p.gram_panchayat_Id\n" +
                    "where g.gram_panchayat_Id = (select gram_panchayat_Id  from project where projectid = ?)";
            PreparedStatement ps = con.prepareStatement(quarry);
            ps.setInt(1,projecId);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                int x = rs.getInt("GP_member_Id");
                String name = rs.getString("GP_member_Name");

                GPMember gpd = new GPMember(x,name);
                gp.add(gpd);

            }

        } catch (SQLException e) {
           e.printStackTrace();
           e.getMessage();
        }
        return gp;
    }

    @Override
    public List<Project> seeTheRemainProject() throws ProjectException {

        List<Project> list= new ArrayList<>();
        try(Connection con = dbutilities.getConnection()){
            String quarry = "Select * from project Where GP_member_Id IS null";

            PreparedStatement ps = con.prepareStatement(quarry);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int x = rs.getInt("projectId");
                String na = rs.getString("projectName");
                String add = rs.getString("projectAddress");
                int gp_Id = rs.getInt("gram_panchayat_Id");
                int gpm_Id = rs.getInt("GP_member_Id");
                int budget = rs.getInt("budget");
                LocalDate start = rs.getDate("start").toLocalDate();
                Date end = rs.getDate("end");

                LocalDate localEndDate = null;
                if (end != null) {
                    localEndDate = end.toLocalDate();
                }

                String loc = rs.getString("location");
                String status = rs.getString("status");

                Project project1 = new Project(x,na,add,gp_Id,gpm_Id,budget,start,localEndDate,loc,status);

                list.add(project1);


            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public List<Project> employeeWorkingProject(int projectID) throws ProjectException {

        List<Project> project = new ArrayList<>();

        try(Connection con = dbutilities.getConnection()) {

            PreparedStatement ps = con.prepareStatement("select p.projectId,p.projectName,p.status,w.wage from project p inner join wage w on w.projectId = p.projectId having projectId = ?");

            ps.setInt(1,projectID);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int x = rs.getInt("projectId");
                String name = rs.getString("projectName");
                String status = rs.getString("status");
                int wage = rs.getInt("wage");

                Project p2 = new Project(x,name,status,wage);
                project.add(p2);
            }


        } catch (SQLException e) {
            e.getMessage();
        }


        return project;
    }


}
