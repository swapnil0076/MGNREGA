package DAO;

import BeanClass.GPMember;
import BeanClass.Project;
import Exception.*;

import java.util.List;

public interface Project_DAO {

    public String addNewProject(Project project) throws ProjectException;
    public List<Project> viewAllProject() throws ProjectException;
    public String AddGPM(GPMember gpMember)throws GPMember_Exception;
    public List<GPMember> viewAllGPMember() throws GPMember_Exception;

    public String allocateTheProject(int gram_Member,int projectId) throws  ProjectException,GPMember_Exception ;

    public List<GPMember> seTheGPMemberUnder(int projecId) throws GPMember_Exception;

    public List<Project> seeTheRemainProject() throws ProjectException;

}
