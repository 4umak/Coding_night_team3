package ua.edu.ukma.e_oss.team3.persistance.entity;
import org.springframework.stereotype.Component;

@Component
public class SO_application {
    private int app_id;
    private int user_id;
    private String name;
    private String description;
    private String aim;
    private boolean approved;
    private String status;
    private String rejected_text;
    private int dekan_id;
    private int sk_id;

    public SO_application(){}

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejected_text() {
        return rejected_text;
    }

    public void setRejected_text(String rejected_text) {
        this.rejected_text = rejected_text;
    }

    public int getDekan_id() {
        return dekan_id;
    }

    public void setDekan_id(int dekan_id) {
        this.dekan_id = dekan_id;
    }

    public int getSk_id() {
        return sk_id;
    }

    public void setSk_id(int sk_id) {
        this.sk_id = sk_id;
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

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "SO_application{" +
                "app_id=" + app_id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", aim='" + aim + '\'' +
                ", approved=" + approved +
                ", status='" + status + '\'' +
                ", rejected_text='" + rejected_text + '\'' +
                ", dekan_id=" + dekan_id +
                ", sk_id=" + sk_id +
                '}';
    }
}
