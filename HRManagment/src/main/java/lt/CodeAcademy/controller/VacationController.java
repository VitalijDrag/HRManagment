package lt.CodeAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.CodeAcademy.model.Employee;
import lt.CodeAcademy.model.Vacation;
import lt.CodeAcademy.service.EmployeeService;
import lt.CodeAcademy.service.VacationService;

@Controller
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("vacations", vacationService.getAllVacations());
        return "vacations/all";
    }

    @PostMapping("/save/{employee_id}")
    public String saveVacation(@ModelAttribute("vacation") Vacation vacation,
            @PathVariable(value = "employee_id") long id) {
        Employee employee = employeeService.getEmployeeById(id);
        vacationService.saveVacation(vacation, employee);
        return "redirect:/employees/details/" + employee.getId();
    }
}
