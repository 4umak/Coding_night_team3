
import ua.edu.ukma.e_oss.team3.entity.SO_application;

public interface SO_applicationService {

    SO_application get(int id);
    int insert(SO_application userJob);
    void update(SO_application userJob);
}
