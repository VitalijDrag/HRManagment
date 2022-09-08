package lt.CodeAcademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.CodeAcademy.model.Employee;
import lt.CodeAcademy.model.Vacation;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
	List<Vacation> findAllByEmployee(Employee employee);

}
