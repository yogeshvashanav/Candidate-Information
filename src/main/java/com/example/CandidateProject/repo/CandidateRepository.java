package com.example.CandidateProject.repo;

import com.example.CandidateProject.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {

    Candidate findByEmail(String email);
}
