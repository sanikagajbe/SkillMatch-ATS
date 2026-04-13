package com.resumescreening.resume_screener.model;

import java.util.List;

public class CandidateRequest {

    private List<String> jobSkills;
    private List<Candidate> candidates;

    // Getters and Setters
    public List<String> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<String> jobSkills) {
        this.jobSkills = jobSkills;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    // Inner class representing a single candidate's input
    public static class Candidate {
        private String id;
        private String resumeText;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getResumeText() {
            return resumeText;
        }

        public void setResumeText(String resumeText) {
            this.resumeText = resumeText;
        }
    }
}
