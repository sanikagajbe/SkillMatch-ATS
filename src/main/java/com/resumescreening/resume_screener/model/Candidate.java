package com.resumescreening.resume_screener.model;
import jakarta.persistence.*;

@Entity // Tells Spring to make a database table out of this class
@Table(name = "candidates")
public class Candidate {

    @Id // This is the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments (1, 2, 3...)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String skills; // We will save the dropdown selections as a comma-separated string

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
}
