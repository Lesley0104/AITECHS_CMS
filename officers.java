package aitechs_cms_copy;

public class officers {
    private int id;
    private String email;
    private String password;
    private String name;
    private String position;
    private String mobile;

    // Full constructor
    public officers(int id, String email, String password, String name, String position, String mobile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.position = position;
        this.mobile = mobile;
    }

    // Minimal constructor (if needed)
    public officers(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // Debug print
    @Override
    public String toString() {
        return "Officer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
