package com.example.cuoiki.controllers;

import com.example.cuoiki.models.Candidate;
import com.example.cuoiki.models.Roles;
import com.example.cuoiki.repositories.CandidateRepo;
import com.example.cuoiki.services.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/home"})
@AllArgsConstructor
public class HomeController {
    private final CandidateRepo candidateRepo;
    private final ExperienceService experienceService;

    @GetMapping("")
    public String home() {
        return "Home";
    }

    @GetMapping("/candidate")
    public String candiate(Model model) {
        model.addAttribute("candidates", candidateRepo.findAll());
        return "/candidate/Candidate";
    }

    @GetMapping("/candidate/candidate_detail/{id}")
    public String candidate_detail(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("candidate", candidateRepo.findById(id).get());

        return "candidate/Candidate_Detail";
    }
    @GetMapping("/candidate/show_add")
    public String showAdd(Model model){
        Candidate candidate = new Candidate();
        model.addAttribute("candidate",candidate);
        return"candidate/add_candidate";
    }
   @PostMapping("/candidate/add")
   public String addCandidate(@ModelAttribute Candidate candidate){
        candidateRepo.save(candidate);
        return"redirect:/candidate";
   }

    @GetMapping("/candidate/show_update/{id}")
    public String showUpdate(@PathVariable("id")long id,Model model){
        Candidate candidate = candidateRepo.findById(id).get();
        model.addAttribute("candidate",candidate);
        return"candidate/update_candidate";
    }
    @PostMapping("/candidate/update")
    public String updateCandidate(@ModelAttribute Candidate candidate){
        System.out.println(candidate);
        candidateRepo.save(candidate);
        return"redirect:/candidate";
    }
    @GetMapping("/candidate/delete/{id}")
    public String removeCandidate(@PathVariable("id")long id,Model model){
        candidateRepo.deleteById(id);
        return"redirect:/candidate";
    }
    @GetMapping ("/report1")

    public String report1(@RequestParam(name = "dropdown", defaultValue = "") String role, Model model) {
        List<String> roles = new ArrayList<String>();
        roles.add(Roles.MANAGER.name());
        roles.add(Roles.STAFF.name());
        roles.add(Roles.EXECUTIVE.name());
        roles.add(Roles.ADMINISTRATION.name());
        model.addAttribute("optionsRole",roles);
        if (!role.equals(""))
            model.addAttribute("candidates", experienceService.getCandidatesByRole(Roles.valueOf(role)));
        return "report/report1";
    }

    @GetMapping("/report2")
    public String report2() {
        return "report/report2";
    }
}
