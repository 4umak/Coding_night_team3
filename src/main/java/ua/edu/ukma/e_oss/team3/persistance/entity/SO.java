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
@Table(name = "SO")
public class SO {
    @Id
    @GeneratedValue
    @Column(name = "so_id")
    private int so_id;

    @Column(name = "application_id")
    private int app_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "aim", columnDefinition = "TEXT")
    private String aim;

    @Column(name = "head")
    private String head;

    @Column(name = "address")
    private String address;

    @Column(name = "tel_num")
    private String tel_num;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String facebook;

    @JsonIgnore
    @OneToMany(mappedBy = "SO", cascade = CascadeType.ALL)
    private List<Job> JobList;
}
