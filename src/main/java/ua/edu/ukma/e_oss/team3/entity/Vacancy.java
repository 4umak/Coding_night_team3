package ua.edu.ukma.e_oss.team3.entity;
import org.springframework.stereotype.Component;
import java.sql.Date;

@Component
public class Vacancy {
    private int vacancy_id;
    private int job_id;
    private boolean active;
    private Date deadline;
    private String comment;

    public Vacancy(){}
    public int getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "vacancy_id=" + vacancy_id +
                ", job_id=" + job_id +
                ", active=" + active +
                ", deadline=" + deadline +
                ", comment='" + comment + '\'' +
                '}';
    }
}
