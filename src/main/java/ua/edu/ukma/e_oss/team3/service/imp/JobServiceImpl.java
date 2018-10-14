package ua.edu.ukma.e_oss.team3.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import ua.edu.ukma.e_oss.team3.dao.JobDao;
import ua.edu.ukma.e_oss.team3.entity.Job;
import ua.edu.ukma.e_oss.team3.service.JobService;

public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public Job get(int id) {
        return jobDao.get(id);
    }

    @Override
    public int insert(Job job) {
        return jobDao.insert(job);
    }

    @Override
    public void update(Job job) {
        jobDao.update(job);
    }
}
