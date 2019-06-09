package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
