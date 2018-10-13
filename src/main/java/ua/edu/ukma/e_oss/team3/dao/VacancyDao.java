package ua.edu.ukma.e_oss.team3.dao;
import ua.edu.ukma.e_oss.team3.entity.Vacancy;
import java.util.List;

public interface VacancyDao {
    Vacancy get(int id);
    int insert(Vacancy vac);
    void update(Vacancy vac);
    void remove(Vacancy vac);
    //List<Vacancy> getVacancyBy();
    List<Vacancy> getAll();
}

