package aitechs_cms_copy;

public class student {
    private int id;
    private String email;
    private String password;
    private String studentNo;
    private String name;
    private String yearLevel;
    private String block;
    private String mobile;
    private String address;
     private String clearance;
    private String requested_at;

    // Full constructor
    public student(int id, String email, String password, String studentNo, String name, String yearLevel, String block, String mobile, String address,String clearance,String requested_at, String string6) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.studentNo = studentNo;
        this.name = name;
        this.yearLevel = yearLevel;
        this.block = block;
        this.mobile = mobile;
        this.address = address;
        this.clearance = clearance;
        this.requested_at = requested_at;
    }

    // Minimal constructor (for signup)
    public student(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    student() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getClearance() {
        return clearance;
    }

    public void setClearance(String clearance) {
        this.clearance = clearance;
    }
    
    public String getRequested_at() {
        return requested_at;
    }

    public void setRequested_at(String requested_at) {
        this.requested_at = requested_at;
    }

    // Optional for debugging
    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", studentNo='" + studentNo + '\'' +
                '}';
    }

   
}
