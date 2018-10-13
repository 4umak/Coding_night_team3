package ua.edu.ukma.e_oss.team3.entity;
import org.springframework.stereotype.Component;

@Component
public class Job {
    private int job_id;
    private int so_id;
    private String title;
    private String description;
    public Job(){
        //this.setSer
    }
    public int getJob_id(){
        return job_id;
    }
    public int getSo_id(){
        return so_id;
    }
    public void setJob_id(int job_id){
        this.job_id = job_id;
    }
    public void setSo_id(int so_id){
        this.so_id = so_id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;

    }

    @Override
    public String toString() {
        return "Job{" +
                "job_id=" + job_id +
                ", so_id=" + so_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
