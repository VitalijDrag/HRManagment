package lt.CodeAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lt.CodeAcademy.service.CandidateService;
import lt.CodeAcademy.service.EmployeeService;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CandidateService candidatesService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		model.addAttribute("candidates", candidatesService.getAllCandidates());
		return "home";
	}

}
