package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();
}
