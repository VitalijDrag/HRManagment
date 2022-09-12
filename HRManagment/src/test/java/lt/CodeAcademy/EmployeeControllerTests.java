package lt.CodeAcademy;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import lt.CodeAcademy.controller.EmployeeController;
import lt.CodeAcademy.model.Employee;
import lt.CodeAcademy.service.EmployeeServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

	@MockBean
	EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void failsIfEmployeesServiceNotAutowired() {
		Assertions.assertThat(employeeServiceImpl).isNotNull();
	}
	
	@Test
	public void shouldReturnListOfEmloyees() throws Exception {
		Employee employee = new Employee();
		List<Employee> employees = Arrays.asList(employee);

		Mockito.when(employeeServiceImpl.getAllEmployees()).thenReturn(employees);

		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeExists("listEmployees"));
	}
	
	@Test
	public void shouldReturnPathToNewEmployeeTemplate() throws Exception {
		mockMvc.perform(get("/showNewEmployeeForm"))
		.andExpect(status()
		.isOk())
		.andExpect(view().name("new_employee"));
	}
	
	@Test
	void shouldAddNewEmployee() throws Exception {
	  this.mockMvc
	    .perform(post("/saveEmployee")
	     .param("first_name", "Dummy")
	     .param("last_name", "LastDummy")
	     .param("email", "dummy@dummy.com"))
	     .andExpect(status().is3xxRedirection())
	     .andExpect(header().string("Location", "/"));
	}
	
	@Test
	void whenSavingMethodSaveSouldBeCalled() {
		Employee employee = new Employee();
		
		employeeServiceImpl.saveEmployee(employee);
		verify(employeeServiceImpl, times(1)).saveEmployee(employee);
	}
}
