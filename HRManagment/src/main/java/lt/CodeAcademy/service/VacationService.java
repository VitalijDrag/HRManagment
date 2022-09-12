package lt.CodeAcademy.service;

import java.util.List;

import lt.CodeAcademy.model.Employee;
import lt.CodeAcademy.model.Vacation;

public interface VacationService {
	
    List<Vacation> getAllVacations();
    List<Vacation> getEmployeeVacations(Employee employee);
    void saveVacation(Vacation vacation, Employee employee);
    Vacation getVacationById(long id);
    void deleteVacationById(long id);
}
