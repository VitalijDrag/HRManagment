package lt.CodeAcademy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.CodeAcademy.model.Candidate;
import lt.CodeAcademy.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        this.candidateRepository.save(candidate);
    }

    @Override
    public Candidate getCandidateById(long id) {
        Optional<Candidate> optional = candidateRepository.findById(id);
        Candidate candidate = null;
        if (optional.isPresent()) {
            candidate = optional.get();
        } else {
            throw new RuntimeException(" Candidate not found for id : " + id);
        }
        return candidate;
    }

    @Override
    public void deleteCandidateById(long id) {
        this.candidateRepository.deleteById(id);
    }

}
