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
@Entity
@Table(name = "UserJob")
public class UserJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobID")
    private int jobID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "startDate")
    private Timestamp startDate;

    @Column(name = "endDate")
    private Timestamp endDate;

    @Column(name = "feedback", columnDefinition = "TEXT")
    private String feedback;

}
