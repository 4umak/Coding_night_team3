package ua.edu.ukma.e_oss.team3.service.impl;

import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.team3.persistance.entity.User;
import ua.edu.ukma.e_oss.team3.service.IUserService;

import java.util.List;
@Service
public class UserService implements IUserService{
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getAll(int page, int limit) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
