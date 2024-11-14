package com.example.CandidateProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
   @Column(unique = true)
    private  String email;
    private String name;
    private Integer experience;
}
