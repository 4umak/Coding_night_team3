package ua.edu.ukma.e_oss.team3.dao;
import ua.edu.ukma.e_oss.team3.entity.User;
import ua.edu.ukma.e_oss.team3.entity.UserJob;
import java.util.List;
public interface UserJobDao {
    UserJob get(int user_id, int job_id, String st_date);
    int insert(UserJob userJob);
    void update(UserJob userJob);
    void remove(UserJob userJob);
    List<UserJob> getUserJobByJob_Id();
    List<UserJob> getAll();
}
