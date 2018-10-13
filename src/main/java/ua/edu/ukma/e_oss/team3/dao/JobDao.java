package ua.edu.ukma.e_oss.team3.dao;
import ua.edu.ukma.e_oss.team3.entity.Job;
import java.util.List;

public interface JobDao {
    Job get(int id);
    int insert(Job job);
    void update(Job job);
    void remove(Job job);
    //List<Job> getJobBy();
    List<Job> getAll();
}
