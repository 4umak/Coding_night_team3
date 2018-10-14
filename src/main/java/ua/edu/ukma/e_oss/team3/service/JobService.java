package ua.edu.ukma.e_oss.team3.service;

import ua.edu.ukma.e_oss.team3.entity.Job;

public interface JobService {
    Job get(int id);
    int insert(Job job);
    void update(Job job);
}
