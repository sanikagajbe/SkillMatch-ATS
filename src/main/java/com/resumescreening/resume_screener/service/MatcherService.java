package com.resumescreening.resume_screener.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

// You must import your model classes and your utility class!
// Update these paths if your base folder is named differently.
import com.resumescreening.resume_screener.model.CandidateRequest.Candidate;
import com.resumescreening.resume_screener.model.RankResult;
import com.resumescreening.resume_screener.utils.TextProcessor;
@Service // This tells Spring Boot this class holds business logic
public class MatcherService {

    public RankResult calculateMatch(Candidate candidate, List<String> jobSkills) {

        List<String> matchedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();

        // 1. Clean the resume text into a list of lowercase words
        List<String> resumeWords = TextProcessor.cleanAndTokenize(candidate.getResumeText());

        // Convert resume words to a single string for easier phrase matching (e.g., "spring boot")
        String fullCleanResume = String.join(" ", resumeWords);

        // 2. Check each job skill against the resume
        for (String skill : jobSkills) {
            String cleanSkill = skill.trim().toLowerCase();

            // If the resume contains the skill, it's a match
            if (fullCleanResume.contains(cleanSkill)) {
                matchedSkills.add(cleanSkill);
            } else {
                missingSkills.add(cleanSkill);
            }
        }

        // 3. Calculate Score (%)
        double score = 0.0;
        if (!jobSkills.isEmpty()) {
            score = ((double) matchedSkills.size() / jobSkills.size()) * 100;
        }

        // Round to 2 decimal places
        score = Math.round(score * 100.0) / 100.0;

        // 4. Determine Suitability
        String suitability;
        if (score >= 75) {
            suitability = "Strong";
        } else if (score >= 50) {
            suitability = "Moderate";
        } else {
            suitability = "Weak";
        }

        // 5. Return the final result
        return new RankResult(candidate.getId(), score, suitability, matchedSkills, missingSkills);
    }
}
