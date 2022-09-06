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
import lt.CodeAcademy.model.Candidate;
import lt.CodeAcademy.model.Vacation;
import lt.CodeAcademy.service.CandidateService;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("candidates", candidateService.getAllCandidates());
        return "candidates/all";
    }

    @GetMapping("/new")
    public String showNewCandidateForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "candidates/new";
    }

    @PostMapping("/save")
    public String saveCandidate(@ModelAttribute("candidate") Candidate candidate) {

        candidateService.saveCandidate(candidate);
        return "redirect:/candidates/all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);

        model.addAttribute("candidate", candidate);
        model.addAttribute("vacation", new Vacation());
        model.addAttribute("absense", new Absense());
        return "candidates/details";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);

        model.addAttribute("candidate", candidate);
        return "candidates/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable(value = "id") long id) {

        this.candidateService.deleteCandidateById(id);
        return "redirect:/candidates/all";
    }
    
}
