package ua.edu.ukma.e_oss.team3.service;

import ua.edu.ukma.e_oss.team3.persistance.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();
    List<User> getAll(int page, int limit);

    User findById(int id);
}
