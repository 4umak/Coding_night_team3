package ua.edu.ukma.e_oss.team3.service;

import ua.edu.ukma.e_oss.team3.persistance.entity.Vacancy;

import java.util.List;

public interface IVacancyService {
    Vacancy create(Vacancy vacancy);
    Vacancy update(Vacancy vacancy);
    List<Vacancy> find(int vacancyID);
    List<Vacancy> find(int page, int limit);
    boolean exists(int vacancyID);
}
