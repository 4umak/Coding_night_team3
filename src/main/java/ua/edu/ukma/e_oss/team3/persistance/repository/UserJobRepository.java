package ua.edu.ukma.e_oss.team3.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.e_oss.team3.persistance.entity.UserJob;

import java.util.List;

public interface UserJobRepository extends JpaRepository<UserJob, Integer>{

    List<UserJob> findUserByEndDate(String endDate);
}
