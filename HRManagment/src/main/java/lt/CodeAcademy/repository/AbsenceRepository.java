package lt.CodeAcademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.CodeAcademy.model.Absence;
import lt.CodeAcademy.model.Employee;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
  List<Absence> findAllByEmployee(Employee employee);
}
