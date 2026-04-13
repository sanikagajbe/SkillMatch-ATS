package com.resumescreening.resume_screener.controller;

import com.resumescreening.resume_screener.model.Candidate;
import com.resumescreening.resume_screener.model.RankResult;
import com.resumescreening.resume_screener.repository.CandidateRepository;
import com.resumescreening.resume_screener.service.MatcherService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ResumeController {

    private final MatcherService matcherService;
    private final CandidateRepository candidateRepository;

    public ResumeController(MatcherService matcherService, CandidateRepository candidateRepository) {
        this.matcherService = matcherService;
        this.candidateRepository = candidateRepository;
    }

    // 1. ENDPOINT FOR CANDIDATES: Save profile to database
    @PostMapping("/candidates")
    public String applyForJob(@RequestBody Candidate candidate) {
        candidateRepository.save(candidate);
        return "Application submitted successfully!";
    }

    // 2. ENDPOINT FOR RECRUITERS: Search and rank database
    @PostMapping("/analyze")
    public List<RankResult> analyzeDatabase(@RequestBody List<String> requiredSkills) {

        List<RankResult> results = new ArrayList<>();
        List<Candidate> allCandidates = candidateRepository.findAll(); // Fetch EVERYONE from the DB

        // Run your existing matcher algorithm on everyone
        for (Candidate dbCandidate : allCandidates) {

            // We use the same Candidate class from your original setup, just adapting the data
            com.resumescreening.resume_screener.model.CandidateRequest.Candidate tempCandidate =
                    new com.resumescreening.resume_screener.model.CandidateRequest.Candidate();
            tempCandidate.setId(dbCandidate.getName());
            tempCandidate.setResumeText(dbCandidate.getSkills());

            RankResult result = matcherService.calculateMatch(tempCandidate, requiredSkills);
            results.add(result);
        }

        // Sort Highest Score First
        results.sort((r1, r2) -> Double.compare(r2.getScore(), r1.getScore()));

        return results;
    }
}