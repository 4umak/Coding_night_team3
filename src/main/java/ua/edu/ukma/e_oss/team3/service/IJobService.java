package ua.edu.ukma.e_oss.team3.service;


import ua.edu.ukma.e_oss.team3.persistance.entity.Job;
import ua.edu.ukma.e_oss.team3.persistance.entity.Vacancy;

import java.util.List;

public interface IJobService {
    Job create(Job job);
    Job update(Job job);
    List<Job> find(int jobID);
    List<Job> find(int page, int limit);
    boolean exists(int jobID);
}
