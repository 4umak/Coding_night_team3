package ua.edu.ukma.e_oss.team3.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.e_oss.team3.persistance.entity.Job;
import ua.edu.ukma.e_oss.team3.persistance.entity.Vacancy;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

    List<Vacancy> findVacancyByName(String name);

}
