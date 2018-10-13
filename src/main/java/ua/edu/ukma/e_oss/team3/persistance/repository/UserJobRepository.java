package ua.edu.ukma.e_oss.team3.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.e_oss.team3.persistance.entity.UserJob;
import ua.edu.ukma.e_oss.team3.persistance.entity.UserJobIdentity;

import javax.persistence.Embeddable;
import java.sql.Timestamp;
import java.util.List;

@Embeddable

public interface UserJobRepository extends JpaRepository<UserJob, UserJobIdentity>{

    List<UserJob> findUserJobsByEndDate(Timestamp endDate);
    List<UserJob> findUserJobsByUserJobIdentity_UserID(int id);
    List<UserJob> findUserJobsByUserJobIdentity_CompanyID(int job_id);
}
