package ua.edu.ukma.e_oss.team3.persistance.repository;
import ua.edu.ukma.e_oss.team3.persistance.entity.SO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SORepository extends JpaRepository<SO,Integer>{
    List<SO> findSOSByName(String name);
    SO findSOByName(String name);
    List<SO> findSOSByso_id(int id);
    void deleteSOByso_id(int id);
}
