package com.resumescreening.resume_screener.repository;

import com.resumescreening.resume_screener.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    // Spring Boot automatically writes all the SQL for finding and saving candidates!
}