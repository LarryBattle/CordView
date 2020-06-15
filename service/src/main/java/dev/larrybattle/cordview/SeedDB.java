package dev.larrybattle.cordview;

import dev.larrybattle.cordview.entity.JobAppRole;
import dev.larrybattle.cordview.entity.JobPosting;
import dev.larrybattle.cordview.entity.User;
import dev.larrybattle.cordview.entity.WageType;
import dev.larrybattle.cordview.repository.JobPostingRepository;
import dev.larrybattle.cordview.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("dev")
public class SeedDB implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SeedDB.class);

    @Autowired
    JobPostingRepository jobPostingRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("* Seeding database *");
        seedUsers();
        seedJobPostings();
    }

    @Transactional
    public void seedUsers() {
        List<User> users = Arrays.asList(
                new User("SYSTEM", "SYSTEM", "admin@example.com", "SYSTEM", JobAppRole.ADMIN, true),
                new User("bob", "smith", "bob.smith@example.com", "Awesome 2.0 Corp", JobAppRole.APPLICANT_REVIEWER, true),
                new User("mary", "smith", "mary.smith@example.com", "Tech Recruiter Inc", JobAppRole.APPLICANT, false)
        );
        users.forEach(user -> userRepository.save(user));

        logger.info("-> User count: " + userRepository.count());
    }

    @Transactional
    public void seedJobPostings() {
        List<JobPosting> jobs = Arrays.asList(
                new JobPosting("Junior Java Microservices Developer", "Know Java? You're hire!", "Dallas, TX", "30.00", WageType.HOURLY),
                new JobPosting("Java Microservices Developer", "Know SpringBoot? You're hire!", "Dallas, TX", "60,000.00", WageType.ANNUALLY),
                new JobPosting("Senior Java Microservices Developer", "Know Java and SpringBoot and JavaScript? You're hire!", "Dallas, TX", "100,000.00", WageType.ANNUALLY)
        );

        jobs.forEach(jobPosting -> jobPostingRepository.save(jobPosting));

        logger.info("-> Job Posting count: " + jobPostingRepository.count());
    }
}
