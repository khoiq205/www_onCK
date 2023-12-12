package com.example.cuoiki.services;

import com.example.cuoiki.models.Candidate;
import com.example.cuoiki.models.Experience;
import com.example.cuoiki.models.Roles;
import com.example.cuoiki.repositories.ExperienceRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExperienceService {
    private ExperienceRepo experienceRepo;
    public List<Candidate> getCandidatesByRole(Roles role){
        return experienceRepo.findByRole(role);
    }
    public Page<Experience> findAll(int pageNo, int pageSize, String sortBy , String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        return experienceRepo.findAll(pageable);

    }
}
