package ua.edu.ukma.e_oss.team3.service;

import ua.edu.ukma.e_oss.team3.entity.User;

public interface UserService {
    User get(int id);
    int insert(User user);
    void update(User user);

}
