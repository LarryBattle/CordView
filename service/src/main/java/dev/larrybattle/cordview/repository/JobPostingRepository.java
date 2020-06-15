package dev.larrybattle.cordview.repository;

import dev.larrybattle.cordview.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    JobPosting findByGlobalId(String globalId);
}
