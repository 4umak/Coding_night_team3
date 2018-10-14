package ua.edu.ukma.e_oss.team3.persistance.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Job")
public class Job {
    @Id
    @GeneratedValue
    @Column(name = "jobID")
    private int job_id;

    @Column(name = "soID")
    private int so_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "Job", cascade = CascadeType.ALL)
    private List<Vacancy> vacancyList;

    @JsonIgnore
    @OneToMany(mappedBy = "Job", cascade = CascadeType.ALL)
    private List<UserJob> userJobList;

    @ManyToOne
    @JoinColumn(name="soID", nullable = false)
    private SO so;



}
