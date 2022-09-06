package lt.CodeAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.CodeAcademy.service.CandidateService;
import lt.CodeAcademy.service.EmployeeService;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private CandidateService candidatesService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("employees", employeeService.getAllEmployees());
    model.addAttribute("candidates", candidatesService.getAllCandidates());
    return "home";
  }
}
