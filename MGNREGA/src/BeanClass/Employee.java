package BeanClass;

public class Employee {

    private int empID;
    private String EName;
    private String EAddress;
    private int gram_panchayat_Id;

    private int projectId;

    public Employee() {
    }

    public Employee(int empID, String EName, String EAddress, int gram_panchayat_Id, int projectId) {
        this.empID = empID;
        this.EName = EName;
        this.EAddress = EAddress;
        this.gram_panchayat_Id = gram_panchayat_Id;
        this.projectId = projectId;
    }


    public Employee(String EName, String EAddress, int gram_panchayat_Id) {
        this.EName = EName;
        this.EAddress = EAddress;
        this.gram_panchayat_Id = gram_panchayat_Id;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public String getEAddress() {
        return EAddress;
    }

    public void setEAddress(String EAddress) {
        this.EAddress = EAddress;
    }

    public int getGram_panchayat_Id() {
        return gram_panchayat_Id;
    }

    public void setGram_panchayat_Id(int gram_panchayat_Id) {
        this.gram_panchayat_Id = gram_panchayat_Id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("empID=").append(empID);
        sb.append(", EName='").append(EName).append('\'');
        sb.append(", EAddress='").append(EAddress).append('\'');
        sb.append(", gram_panchayat_Id=").append(gram_panchayat_Id);
        sb.append(", projectId=").append(projectId);
        return sb.toString();
    }
}
