package ua.edu.ukma.e_oss.team3.persistance.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString()
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int user_id;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "tel_num")
    private String tel_num;

    @JsonIgnore
    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private List<SO_application> soApplicationList;
}
