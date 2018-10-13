package ua.edu.ukma.e_oss.team3.entity;
import org.springframework.stereotype.Component;

@Component
public class User {
    private int user_id;
    private String role;
    private String name;
    private String email;
    private String tel_num;

    public User(){}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getTel_num() {
        return tel_num;
    }

    public void setTel_num(String tel_num) {
        this.tel_num = tel_num;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel_num='" + tel_num + '\'' +
                '}';
    }
}
