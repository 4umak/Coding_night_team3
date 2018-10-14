package ua.edu.ukma.e_oss.team3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ua.edu.ukma.e_oss.team3.persistance.entity.Vacancy;
import ua.edu.ukma.e_oss.team3.persistance.repository.VacancyRepository;
import ua.edu.ukma.e_oss.team3.service.IVacancyService;

import java.util.List;

public class VacancyService implements IVacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public Vacancy create(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy update(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    //TODO fix find by name or id
    @Override
    public List<Vacancy> find(int vacancyID) {
        return vacancyRepository.findAll();
    }

    @Override
    public List<Vacancy> find(int page, int limit) {
        if (limit > 30) {
            limit = 30;
        }

        if (page < 0) {
            page = 0;
        }
        // fix PageRequest deprecated
        return vacancyRepository.findAll(new PageRequest(page, limit)).getContent();
    }

    @Override
    public boolean exists(int vacancyID) {
        return vacancyRepository.existsById(vacancyID);
    }
}
