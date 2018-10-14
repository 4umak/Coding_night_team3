package ua.edu.ukma.e_oss.team3.persistance.entity;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString()
@Entity
@Table(name = "SO_application")
public class SO_application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationID")
    private int app_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "aim")
    private String aim;

    @Column(name = "approved", columnDefinition = "SMALLINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean approved;

    @Column(name = "status")
    private String status;

    @Column(name = "rejected_text")
    private String rejected_text;

    @Column(name = "dekanID")
    private int dekan_id;

    @Column(name = "skID")
    private int sk_id;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;
}
