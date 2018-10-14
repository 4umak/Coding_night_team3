package ua.edu.ukma.e_oss.team3.service;
import ua.edu.ukma.e_oss.team3.persistance.entity.*;

import java.util.List;

public interface ISOService {
    List<SO> findByTitle(String title);
    List<SO> findAll();
    SO create(SO so);
    void  delete(int id);
    SO update(SO soToUpdate);
    List<UserJob> getHistory(int so_id);
}