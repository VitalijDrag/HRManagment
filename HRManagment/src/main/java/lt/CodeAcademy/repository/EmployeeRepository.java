package lt.CodeAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.CodeAcademy.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
