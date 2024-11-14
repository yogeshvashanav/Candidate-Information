package com.example.CandidateProject.service;

import com.example.CandidateProject.domain.Candidate;
import org.springframework.http.ResponseEntity;

public interface CandidateService {
    ResponseEntity<?> addNewCandidate(Candidate candidate);
    ResponseEntity<?> getAllCandidates();
    ResponseEntity<?> getCandidateById(Long id);
    ResponseEntity<?> updateCandidate(Long id, Candidate candidate);
    ResponseEntity<?> deleteCandidate(Long id);
}
