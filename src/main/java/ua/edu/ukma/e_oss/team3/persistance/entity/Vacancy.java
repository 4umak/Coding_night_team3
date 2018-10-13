package ua.edu.ukma.e_oss.team3.persistance.entity;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString()
@Entity
@Table(name = "Vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacancyID")
    private Integer vacancyID;

    @ManyToOne
    @JoinColumn(name="vacancyID", nullable = false)
    private Job job;

    @Column(name = "active", columnDefinition = "SMALLINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;

    @Column(name = "deadline")
    private Timestamp deadline;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;


}
