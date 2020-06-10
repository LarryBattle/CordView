package dev.larrybattle.cordview.repository;

import dev.larrybattle.cordview.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO Find out if the Repository is needed.
@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    JobPosting findByGlobalId(String globalId);
}
