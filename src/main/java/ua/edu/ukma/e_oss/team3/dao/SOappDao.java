package ua.edu.ukma.e_oss.team3.dao;
import ua.edu.ukma.e_oss.team3.entity.SO_application;
import java.util.List;

public interface SOappDao {
    SO_application get(int id);
    int insert(SO_application soApp);
    void update(SO_application soApp);
    //void remove(SO_application soApp);
    //List<SO_application> getSOappBy();
    List<SO_application> getAll();
}
