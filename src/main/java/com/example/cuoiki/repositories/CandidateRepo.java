package com.example.cuoiki.repositories;

import com.example.cuoiki.models.Candidate;
import com.example.cuoiki.models.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepo extends JpaRepository<Candidate,Long> {

}
