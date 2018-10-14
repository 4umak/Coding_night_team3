package ua.edu.ukma.e_oss.team3.service.impl;

import ua.edu.ukma.e_oss.team3.persistance.repository.JobRepository;
import ua.edu.ukma.e_oss.team3.persistance.repository.SORepository;
import ua.edu.ukma.e_oss.team3.persistance.repository.UserJobRepository;
import ua.edu.ukma.e_oss.team3.persistance.repository.UserRepository;
import ua.edu.ukma.e_oss.team3.service.ISOService;
import ua.edu.ukma.e_oss.team3.persistance.entity.*;
import javax.annotation.Resource;
import java.util.*;

public class SOService implements ISOService {
    @Resource
    private SORepository soRepository;

    @Resource
    private JobRepository jobRepository;

    @Resource
    private UserJobRepository userJobRepository;

    @Resource
    private UserRepository userRepository;

    @Override
    public List<SO> findByTitle(String title) {
        return soRepository.findSOSByName(title);
    }

    @Override
    public List<SO> findAll() {
        return soRepository.findAll();
    }

    @Override
    public SO create(SO so) {
        return soRepository.save(so);
    }

    @Override
    public void delete(int id) {
        SO s = soRepository.findById(id).orElse(null);
        if(s!=null){
            soRepository.deleteSOByso_id(id);
        }
    }

    @Override
    public SO update(SO soToUpdate) {
        return soRepository.save(soToUpdate);
    }

    @Override
    public List<String> getHistory(int so_id) {
        List<Job> jobs = jobRepository.findJobsByso_id(so_id);
        List<UserJob> u_jobs = new ArrayList<UserJob>();
        for(Job job : jobs)
         u_jobs.addAll(userJobRepository.findUserJobsByUserJobIdentity_CompanyID(job.getJob_id()));
        List<String> history = new ArrayList<>();
        for (UserJob userJob : u_jobs)
            history.add(userRepository.getOne(userJob.getUserJobIdentity().getUserID()).getName() + ": " + userJob.getStartDate() + " - " + userJob.getEndDate());
        return  history;
    }
}
