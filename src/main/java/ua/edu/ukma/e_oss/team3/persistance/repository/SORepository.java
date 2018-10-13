package ua.edu.ukma.e_oss.team3.persistance.repository;
import ua.edu.ukma.e_oss.team3.persistance.entity.SO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SORepository extends JpaRepository<SO,Integer>{
    List<SO> finSOByName(String name);
}
