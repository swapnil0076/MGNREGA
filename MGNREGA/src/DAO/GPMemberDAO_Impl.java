package DAO;

import BeanClass.Employee;
import BeanClass.Wage;
import Custom_Colors.Colors;
import Exception.*;
import Utility.dbutilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GPMemberDAO_Impl implements GPMember_DAO{
    @Override

        public boolean LoginAsGPMember(int id, int password) throws GPMember_Exception {
            boolean flag = false;
            String mess = "LogIn ID Not Found";

            try(Connection con = dbutilities.getConnection()) {

                PreparedStatement ps =    con.prepareStatement("SELECT GP_member_Id, GP_member_Name, GP_member_Address, gram_panchayat_Id FROM gram_panchayat_member WHERE   GP_member_Id = ? AND GP_member_Password = ?");

                ps.setInt(1,id);
                ps.setInt(2,password);

                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int x = rs.getInt("GP_member_Id");
                    String name = rs.getString("GP_member_Name");
                    int pan = rs.getInt("gram_panchayat_Id");
                    String add = rs.getString("GP_member_Address");

                    mess = "Welcome "+name+" "+"\n"+"Gram Panchayat ID "+x+"\n"+"Belong to Gram Panchayat "+add+" "+"Gram panchayat id "+pan;
                    System.out.println(mess);
                    return true;

                }else{
                    throw new GPMember_Exception("Gram Panchayat Member not Found");
                }

            } catch (SQLException e) {
                e.getMessage();
                e.printStackTrace();
            }

            return false;
        }

    @Override
    public String addEmployee(Employee employee) throws Employee_Exception {
        String mess = "Failed to Add to Employee";

        try(Connection con = dbutilities.getConnection()){

            String quarry = "insert into Employee values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(quarry);
            ps.setInt(1,employee.getEmpID());
            ps.setString(2,employee.getEName());
            ps.setString(3,employee.getEAddress());
            ps.setInt(4,employee.getGram_panchayat_Id());

            int x = ps.executeUpdate();

            if(x>0){
                mess = "Employee Add Successfully";
            }else{
                throw new Employee_Exception("Check the creditionals");
            }


        } catch (SQLException e) {
            e.getMessage();
        }

        return mess;
    }

    @Override
    public List<Employee> ViewEmployee(int panchayatId) throws Employee_Exception {

        List<Employee> empd = new ArrayList<>();

        try(Connection con = dbutilities.getConnection()) {

            PreparedStatement ps = con.prepareStatement("Select * from Employee where gram_panchayat_Id = ?");

            ps.setInt(1,panchayatId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int x = rs.getInt("empID");
                String na = rs.getString("EName");
                String add = rs.getString("EAddress");
                int panchyatI_Id = rs.getInt("gram_panchayat_Id");
                int proId = rs.getInt("projectID");

                Employee emp = new Employee(x,na,add,panchyatI_Id,proId);

                empd.add(emp);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return empd;
    }

    @Override
    public String assignEmployee(int empId, int projectId) throws Employee_Exception, ProjectException {
        String mess = "Failed to assign Employee";

        try(Connection con = dbutilities.getConnection()) {

            PreparedStatement ps = con.prepareStatement("Update Employee set projectId = ? where empId = ?");
            ps.setInt(1,projectId);
            ps.setInt(2,empId);

            int x = ps.executeUpdate();

            if(x>0){
                mess = Colors.BANANA_YELLOW+"Successfully Added the project to Employee"+Colors.RESET;
            }else{
                throw new Employee_Exception("Employee not found");
            }

        } catch (SQLException e) {
           e.getMessage();
        }

        return mess;
    }

    @Override
    public String noOfDaysEmployee(int empId) throws Employee_Exception {
        String mess = "Wrong EmpID";

        try(Connection con = dbutilities.getConnection()) {

            PreparedStatement ps = con.prepareStatement("Select count(*)as NoOFDays from Wage where employee_id = ? ");

            ps.setInt(1,empId);
            ResultSet rs = ps.executeQuery();
            int x = 0;
            while(rs.next()){
                x += rs.getInt("NoOFDays");

            }
            mess = String.valueOf(x)+" Days";


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mess;
    }

    @Override
    public String employeeAttendence(Wage wage) throws Employee_Exception {
        String mess = "Wrong Employee iD";

        try(Connection con = dbutilities.getConnection()){

            PreparedStatement ps = con.prepareStatement("Insert into Wage(employee_id,projectId,gram_panchayat_Id,wage) values(?,?,?,?) ");

            ps.setInt(1,wage.getEmployee_id());
            ps.setInt(2,wage.getProjectId());
            ps.setInt(3,wage.getGram_panchayat_Id());
            ps.setInt(4,wage.getWage());

            int x = ps.executeUpdate();

            if(x>0){
                mess = "Wages added Successfully";
            }else{
                throw  new Employee_Exception("Employee Not Found");
            }

        }catch (SQLException e) {
            e.getMessage();
        }



        return mess;
    }

    @Override
    public String ChangeStatusofProject(int project, String status) throws ProjectException {

        String mess = "Project Not Found";

        try (Connection con = dbutilities.getConnection()){

            PreparedStatement ps = con.prepareStatement("Update project set status = ? where projectID = ?");
            ps.setString(1,status);
            ps.setInt(2,project);

            int x = ps.executeUpdate();

            if(x>0){
                mess = "Project Status Updated";
            }else{
                throw new ProjectException("Check the details");
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        return mess;
    }


}
