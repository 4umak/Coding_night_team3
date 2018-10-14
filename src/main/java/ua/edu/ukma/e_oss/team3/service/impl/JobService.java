package ua.edu.ukma.e_oss.team3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ua.edu.ukma.e_oss.team3.persistance.entity.Job;
import ua.edu.ukma.e_oss.team3.persistance.repository.JobRepository;
import ua.edu.ukma.e_oss.team3.service.IJobService;

import java.util.List;

public class JobService implements IJobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job create(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job update(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> find(int jobID) {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> find(int page, int limit) {

        if (page > 30) {
            page = 30;
        }
        if (limit < 0) {
            limit = 0;
        }

        // fix PageRequest deprecated
        return jobRepository.findAll(new PageRequest(page, limit)).getContent();
    }

    @Override
    public boolean exists(int jobID) {
        return jobRepository.existsById(jobID);
    }
}
