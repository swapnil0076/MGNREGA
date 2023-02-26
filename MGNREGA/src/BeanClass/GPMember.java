package BeanClass;

public class GPMember {

    private int GP_member_Id;
    private String  GP_member_Name;
    private String  GP_member_Address;
    private String  GP_member_Password;
    private int gram_panchayat_Id;

    public GPMember() {
    }

    public GPMember(int GP_member_Id, String GP_member_Name, String GP_member_Address, String GP_member_Password, int gram_panchayat_Id) {
        this.GP_member_Id = GP_member_Id;
        this.GP_member_Name = GP_member_Name;
        this.GP_member_Address = GP_member_Address;
        this.GP_member_Password = GP_member_Password;
        this.gram_panchayat_Id = gram_panchayat_Id;
    }

    public GPMember(int GP_member_Id, String GP_member_Name) {
        this.GP_member_Id = GP_member_Id;
        this.GP_member_Name = GP_member_Name;
    }



    public GPMember(int GP_member_Id, String GP_member_Name, String GP_member_Address, int gram_panchayat_Id) {
        this.GP_member_Id = GP_member_Id;
        this.GP_member_Name = GP_member_Name;
        this.GP_member_Address = GP_member_Address;
        this.gram_panchayat_Id = gram_panchayat_Id;
    }

    public GPMember(String GP_member_Name, String GP_member_Address, String GP_member_Password, int gram_panchayat_Id) {
        this.GP_member_Name = GP_member_Name;
        this.GP_member_Address = GP_member_Address;
        this.GP_member_Password = GP_member_Password;
        this.gram_panchayat_Id = gram_panchayat_Id;
    }

    public int getGP_member_Id() {
        return GP_member_Id;
    }

    public void setGP_member_Id(int GP_member_Id) {
        this.GP_member_Id = GP_member_Id;
    }

    public String getGP_member_Name() {
        return GP_member_Name;
    }

    public void setGP_member_Name(String GP_member_Name) {
        this.GP_member_Name = GP_member_Name;
    }

    public String getGP_member_Address() {
        return GP_member_Address;
    }

    public void setGP_member_Address(String GP_member_Address) {
        this.GP_member_Address = GP_member_Address;
    }

    public String getGP_member_Password() {
        return GP_member_Password;
    }

    public void setGP_member_Password(String GP_member_Password) {
        this.GP_member_Password = GP_member_Password;
    }

    public int getGram_panchayat_Id() {
        return gram_panchayat_Id;
    }

    public void setGram_panchayat_Id(int gram_panchayat_Id) {
        this.gram_panchayat_Id = gram_panchayat_Id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GPMember{");
        sb.append("GP_member_Id=").append(GP_member_Id);
        sb.append(", GP_member_Name='").append(GP_member_Name).append('\'');
        sb.append(", GP_member_Address='").append(GP_member_Address).append('\'');
        sb.append(", gram_panchayat_Id=").append(gram_panchayat_Id);
        sb.append('}');
        return sb.toString();
    }

}
