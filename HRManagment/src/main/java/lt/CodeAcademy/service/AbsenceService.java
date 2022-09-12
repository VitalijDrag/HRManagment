package lt.CodeAcademy.service;

import java.util.List;

import lt.CodeAcademy.model.Absence;
import lt.CodeAcademy.model.Employee;

public interface AbsenceService {
	
	List<Absence> getAllAbsences();
	List<Absence> getEmployeeAbsences(Employee employee);
	void saveAbsence(Absence absence, Employee employee);
	Absence getAbsenceById(long id);
	void deleteAbsenceById(long id);
}
