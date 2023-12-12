package com.example.cuoiki.services;

import com.example.cuoiki.models.Candidate;
import com.example.cuoiki.repositories.CandidateRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidateService  {
    CandidateRepo candidateRepo;
}
