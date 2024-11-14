package com.example.CandidateProject.controller;

import com.example.CandidateProject.domain.Candidate;
import com.example.CandidateProject.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @PostMapping("/")
    ResponseEntity<?> addNewCandidate(@RequestBody Candidate candidate){
        return candidateService.addNewCandidate(candidate);
    }
    @PutMapping("/{id}")
    ResponseEntity<?> updateCandidate(@PathVariable Long id,@RequestBody Candidate candidate){
        return candidateService.updateCandidate(id,candidate);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getCandidate(@PathVariable Long id){
        return candidateService.getCandidateById(id);
    }
    @GetMapping("/")
    ResponseEntity<?> getCandidates(){
        return candidateService.getAllCandidates();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCandidate(@PathVariable Long id){
        return candidateService.deleteCandidate(id);
    }

}
