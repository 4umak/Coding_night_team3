package ua.edu.ukma.e_oss.team3.service;

import ua.edu.ukma.e_oss.team3.entity.Vacancy;

public interface VacancyService {

    Vacancy get(int id);
    int insert(Vacancy user);
    void update(Vacancy user);
}
