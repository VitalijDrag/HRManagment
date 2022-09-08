package lt.CodeAcademy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.CodeAcademy.model.Absence;
import lt.CodeAcademy.model.Employee;
import lt.CodeAcademy.repository.AbsenceRepository;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence getAbsenceById(long id) {
        Optional<Absence> optional = absenceRepository.findById(id);
        Absence absence = null;
        if (optional.isPresent()) {
            absence = optional.get();
        } else {
            throw new RuntimeException(" Absense not found for id : " + id);
        }
        return absence;
    }

    @Override
    public void deleteAbsenceById(long id) {
        this.absenceRepository.deleteById(id);
    }

    @Override
    public void saveAbsence(Absence Absence, Employee employee) {
        Absence _absence = Absence;
        Absence.setEmployee(employee);
        this.absenceRepository.save(_absence);
    }

    @Override
    public List<Absence> getEmployeeAbsences(Employee employee) {
        return absenceRepository.findAllByEmployee(employee);
    }
}
