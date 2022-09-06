package lt.CodeAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.CodeAcademy.model.Absense;
import lt.CodeAcademy.model.Employee;
import lt.CodeAcademy.model.Vacation;
import lt.CodeAcademy.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "employees/all";
	}

	@GetMapping("/newEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employees/update_employee";
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/employees/";
	}
	
	 @GetMapping("/details/{id}")
	    public String details(@PathVariable(value = "id") long id, Model model) {
	        Employee employee = employeeService.getEmployeeById(id);

	        model.addAttribute("employee", employee);
	        model.addAttribute("vacation", new Vacation());
	        model.addAttribute("absense", new Absense());
	        return "employees/details";
	    }
}
