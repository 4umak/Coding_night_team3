package ua.edu.ukma.e_oss.team3.dao;
import ua.edu.ukma.e_oss.team3.entity.SO;
import java.util.List;

public interface SODao {
    SO get(int id);
    int insert(SO so);
    void update(SO so);
    void remove(SO so);
    //List<SO> getSoBy();
    List<SO> getAll();
}
