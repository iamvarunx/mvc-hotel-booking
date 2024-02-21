package Model;

public class User {
    private static int id;
    private String name;
    private String email;
    private String role;
    private String phoneNo;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public User(String name, String email, String phoneNo, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    public User(int ID, String name, String role, String phoneNo, String password) {
        id = ID;
        this.name = name;
        this.role = role;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public User() {
        // TODO Auto-generated constructor stub
    }

    public static int getId() {
        return id;
    }

    public static void setId(int ID) {
        id = ID;
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
