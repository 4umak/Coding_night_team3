package ua.edu.ukma.e_oss.team3.dao;
import ua.edu.ukma.e_oss.team3.entity.User;
import java.util.List;

public interface UserDao {
    User get(int id);
    int insert(User user);
    void update(User user);
    void remove(User user);
    //List<User> getUserBy();
    List<User> getAll();
}
