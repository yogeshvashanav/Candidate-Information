package com.example.CandidateProject.service;

import com.example.CandidateProject.domain.Candidate;
import com.example.CandidateProject.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService{
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public ResponseEntity<?> addNewCandidate(Candidate candidate) {
        if(candidate.getEmail() == null || candidate.getName() == null){
            return new ResponseEntity<>("Email and Name can not be empty.",HttpStatus.BAD_GATEWAY);
        }
       Candidate candidate1 = candidateRepository.findByEmail(candidate.getEmail());
        if(candidate1 == null){
            candidateRepository.save(candidate);
            return new ResponseEntity<>("Candidate Added successfully.. !!",HttpStatus.OK);
        }else return new ResponseEntity<>("Another candidate already exist with same email",HttpStatus.BAD_GATEWAY);

    }

    @Override
    public ResponseEntity<?> getAllCandidates() {
        return new ResponseEntity<>(candidateRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCandidateById(Long id) {
        Optional<Candidate> candidate =  candidateRepository.findById(id);
        if(candidate.isPresent()){
            return new ResponseEntity<>(candidate.get(),HttpStatus.OK);
        }else
            return new ResponseEntity<>("Candidate not found",HttpStatus.BAD_GATEWAY);
    }

    @Override
    public ResponseEntity<?> updateCandidate(Long id, Candidate candidate) {
        if(candidate.getEmail() == null || candidate.getName() == null){
            return new ResponseEntity<>("Email and Name can not be empty.",HttpStatus.BAD_GATEWAY);
        }
           Optional<Candidate> candidate2 =  candidateRepository.findById(id);
        if(candidate2.isPresent()){
            Candidate candidate1 = null;
            if(!candidate2.get().getEmail().equalsIgnoreCase(candidate.getEmail()))
             candidate1 = candidateRepository.findByEmail(candidate.getEmail());
            if(candidate1 == null){
                candidateRepository.save(candidate);
                return new ResponseEntity<>("Candidate data updated successfully.. !!",HttpStatus.OK);
            }else return new ResponseEntity<>("Another candidate already exist with same email",HttpStatus.BAD_GATEWAY);

        }else return new ResponseEntity<>("Candidate not found !!.",HttpStatus.BAD_GATEWAY);


    }

    @Override
    public ResponseEntity<?> deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
        new ResponseEntity<>("Candidate deleted successfully.. !!",HttpStatus.OK);
        return null;
    }
}
