package ua.edu.ukma.e_oss.team3.service;
import ua.edu.ukma.e_oss.team3.entity.SO_application;

public interface SO_applicationService {

    SO_application get(int id);
    int insert(SO_application so);
    void update(SO_application so);
}
