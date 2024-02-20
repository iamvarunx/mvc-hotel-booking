package Model;

public class User {
    private int id;
    private String name;
    private String email;
    private String role;
    private String phoneNo;
    private String password;
    
    public User(String email,String password)
    {
        this.email=email;
        this.password=password;

    }
    public User(String name,String email,String phoneNo,String password)
    {
        this.email=email;
        this.name=name;
        this.password=password;
        this.phoneNo=phoneNo;
    }
    
    public User(int id,String name,String role,String phoneNo,String password)
    {
        this.id=id;
        this.name=name;
        this.role=role;
        this.phoneNo=phoneNo;
        this.password=password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
