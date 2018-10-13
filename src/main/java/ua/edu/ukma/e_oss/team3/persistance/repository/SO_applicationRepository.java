package ua.edu.ukma.e_oss.team3.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.e_oss.team3.persistance.entity.SO_application;

import java.util.List;

public interface SO_applicationRepository extends JpaRepository<SO_application, Integer> {
    List<SO_application> findSO_applicationsByApproved(Boolean approved);
}
