package ua.edu.ukma.e_oss.team3.persistance.entity;
import lombok.*;
import org.springframework.stereotype.Component;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString()
@Embeddable
@Entity
@Table(name = "UserJob")
public class UserJob {

    @Embedded
    private UserJobIdentity userJobIdentity;

    @Column(name = "endDate")
    private Timestamp endDate;

    @Column(name = "feedback", columnDefinition = "TEXT")
    private String feedback;

    @ManyToOne
    @JoinColumn(name="userID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="jobID", nullable = false)
    private Job job;


}
