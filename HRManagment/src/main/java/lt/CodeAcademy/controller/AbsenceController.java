package lt.CodeAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lt.CodeAcademy.model.Absence;
import lt.CodeAcademy.model.Employee;
import lt.CodeAcademy.service.AbsenceService;
import lt.CodeAcademy.service.EmployeeService;

@Controller
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("Absences", absenceService.getAllAbsences());
        return "absences/all";
    }
   
    @PostMapping("/save/{employee_id}")
    public String saveAbsence(@ModelAttribute("absence") Absence absence,
            @PathVariable(value = "employee_id") long id) {
        Employee employee = employeeService.getEmployeeById(id);
        absenceService.saveAbsence(absence, employee);
        return "redirect:/employees/details/" + employee.getId();
    }
}
