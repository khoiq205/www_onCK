package com.example.cuoiki.repositories;

import com.example.cuoiki.models.Candidate;
import com.example.cuoiki.models.Experience;
import com.example.cuoiki.models.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExperienceRepo extends JpaRepository<Experience,Long> {

    @Query("SELECT e.candidate FROM  Experience e where e.role = :role order by e.candidate.id ")
    public List<Candidate> findByRole(@Param("role") Roles role);

}
