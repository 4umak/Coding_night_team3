package ua.edu.ukma.e_oss.team3.persistance.repository;
import ua.edu.ukma.e_oss.team3.persistance.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer>{
    List<Job>  findJobByTitle(String title);
}
