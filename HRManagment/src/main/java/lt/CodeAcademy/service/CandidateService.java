package lt.CodeAcademy.service;

import java.util.List;

import lt.CodeAcademy.model.Candidate;

public interface CandidateService {
	
    List<Candidate> getAllCandidates();
    void saveCandidate(Candidate candidate);
    Candidate getCandidateById(long id);
    void deleteCandidateById(long id);
}
