package com.resumescreening.resume_screener.model;

import java.util.List;

public class RankResult {

    private String id;
    private double score;
    private String suitability;
    private List<String> matchedSkills;
    private List<String> missingSkills;

    // Constructor to easily create a result
    public RankResult(String id, double score, String suitability, List<String> matchedSkills, List<String> missingSkills) {
        this.id = id;
        this.score = score;
        this.suitability = suitability;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
    }

    // Getters
    public String getId() { return id; }
    public double getScore() { return score; }
    public String getSuitability() { return suitability; }
    public List<String> getMatchedSkills() { return matchedSkills; }
    public List<String> getMissingSkills() { return missingSkills; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setScore(double score) { this.score = score; }
    public void setSuitability(String suitability) { this.suitability = suitability; }
    public void setMatchedSkills(List<String> matchedSkills) { this.matchedSkills = matchedSkills; }
    public void setMissingSkills(List<String> missingSkills) { this.missingSkills = missingSkills; }
}