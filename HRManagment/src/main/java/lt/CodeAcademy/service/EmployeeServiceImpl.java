package lt.CodeAcademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lt.CodeAcademy.model.Employee;
import lt.CodeAcademy.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
