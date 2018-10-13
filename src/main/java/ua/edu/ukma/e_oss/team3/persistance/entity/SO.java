package ua.edu.ukma.e_oss.team3.persistance.entity;
import org.springframework.stereotype.Component;

@Component
public class SO {
    private int so_id;
    private int app_id;
    private String name;
    private String description;
    private String aim;
    private String head;
    private String address;
    private String tel_num;
    private String email;
    private String facebook;

    public SO(){}

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel_num() {
        return tel_num;
    }

    public void setTel_num(String tel_num) {
        this.tel_num = tel_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public int getSo_id() {
        return so_id;
    }

    public void setSo_id(int so_id) {
        this.so_id = so_id;
    }

    @Override
    public String toString() {
        return "SO{" +
                "so_id=" + so_id +
                ", app_id=" + app_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", aim='" + aim + '\'' +
                ", head='" + head + '\'' +
                ", address='" + address + '\'' +
                ", tel_num='" + tel_num + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }
}
