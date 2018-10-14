package ua.edu.ukma.e_oss.team3.service;

import ua.edu.ukma.e_oss.team3.entity.UserJob;

public interface UserJobService {
    UserJob get(int id);
    int insert(UserJob userJob);
    void update(UserJob userJob);
}
