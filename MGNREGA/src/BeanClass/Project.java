package BeanClass;

import java.sql.Date;
import java.time.LocalDate;

public class Project {

    private int projectId;
    private String projectName ;
    private String projectAddress;
    private int gram_panchayat_Id;
    private int GP_member_Id;
    private int budget;
    private LocalDate start;
    private LocalDate end;
    private String location;
    private String status;

    public Project() {};

    public Project(int projectId, String projectName, String projectAddress, int gram_panchayat_Id, int GP_member_Id, int budget, LocalDate start, LocalDate end, String location, String status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectAddress = projectAddress;
        this.gram_panchayat_Id = gram_panchayat_Id;
        this.GP_member_Id = GP_member_Id;
        this.budget = budget;
        this.start = start;
        this.end = end;
        this.location = location;
        this.status = status;
    }

    public Project(String projectName, String projectAddress, int gram_panchayat_Id, int budget, String location) {
        this.projectName = projectName;
        this.projectAddress = projectAddress;
        this.gram_panchayat_Id = gram_panchayat_Id;
        this.budget = budget;
        this.location = location;
    }

    public Project(String projectName, String projectAddress, int budget, String location) {
        this.projectName = projectName;
        this.projectAddress = projectAddress;
        this.budget = budget;
        this.location = location;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public int getGram_panchayat_Id() {
        return gram_panchayat_Id;
    }

    public void setGram_panchayat_Id(int gram_panchayat_Id) {
        this.gram_panchayat_Id = gram_panchayat_Id;
    }

    public int getGP_member_Id() {
        return GP_member_Id;
    }

    public void setGP_member_Id(int GP_member_Id) {
        this.GP_member_Id = GP_member_Id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectAddress='" + projectAddress + '\'' +
                ", gram_panchayat_Id=" + gram_panchayat_Id +
                ", GP_member_Id=" + GP_member_Id +
                ", budget=" + budget +
                ", start=" + start +
                ", end=" + end +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
