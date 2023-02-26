package DAO;

import BeanClass.Employee;
import BeanClass.Wage;
import Exception.*;

import java.util.List;

public interface GPMember_DAO {

    public boolean LoginAsGPMember(int id ,int password) throws GPMember_Exception;
    public String addEmployee(Employee employee) throws Employee_Exception;

    public List<Employee> ViewEmployee(int panchayatId) throws  Employee_Exception;

    public String assignEmployee(int empId,int projectId) throws Employee_Exception,ProjectException;

    public String noOfDaysEmployee(int empId) throws Employee_Exception;

    public String employeeAttendence(Wage wage) throws Employee_Exception;

    public String ChangeStatusofProject(int project,String status) throws ProjectException;

}
