package ua.edu.ukma.e_oss.team3.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.e_oss.team3.persistance.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
    boolean existsByEmail(String email);
}
