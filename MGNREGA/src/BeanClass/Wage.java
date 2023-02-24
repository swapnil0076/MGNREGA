package BeanClass;

import java.time.LocalDate;

public class Wage {

    private int Wage_Id;
    private int employee_id;
    private int projectId;
    private int gram_panchayat_Id;

    public Wage(int employee_id, int projectId, int gram_panchayat_Id, int wage) {
        this.employee_id = employee_id;
        this.projectId = projectId;
        this.gram_panchayat_Id = gram_panchayat_Id;
        this.wage = wage;
    }

    private LocalDate wage_date;
    private int wage;

    public Wage() {
    }

    public Wage(int wage_Id, int employee_id, int projectId, int gram_panchayat_Id, LocalDate wage_date, int wage) {
        Wage_Id = wage_Id;
        this.employee_id = employee_id;
        this.projectId = projectId;
        this.gram_panchayat_Id = gram_panchayat_Id;
        this.wage_date = wage_date;
        this.wage = wage;
    }

    public int getWage_Id() {
        return Wage_Id;
    }

    public void setWage_Id(int wage_Id) {
        Wage_Id = wage_Id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getGram_panchayat_Id() {
        return gram_panchayat_Id;
    }

    public void setGram_panchayat_Id(int gram_panchayat_Id) {
        this.gram_panchayat_Id = gram_panchayat_Id;
    }

    public LocalDate getWage_date() {
        return wage_date;
    }

    public void setWage_date(LocalDate wage_date) {
        this.wage_date = wage_date;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Wage_Id=").append(Wage_Id);
        sb.append(", employee_id=").append(employee_id);
        sb.append(", projectId=").append(projectId);
        sb.append(", gram_panchayat_Id=").append(gram_panchayat_Id);
        sb.append(", wage_date=").append(wage_date);
        sb.append(", wage=").append(wage);
        return sb.toString();
    }
}
