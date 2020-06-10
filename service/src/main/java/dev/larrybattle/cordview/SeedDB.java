package dev.larrybattle.cordview;

import dev.larrybattle.cordview.entity.JobAppRole;
import dev.larrybattle.cordview.entity.JobPosting;
import dev.larrybattle.cordview.entity.User;
import dev.larrybattle.cordview.repository.JobPostingRepository;
import dev.larrybattle.cordview.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        User user = new User();
        user.setActive(true);
        user.setCompany("system");
        user.setInternal(true);
        user.setFirstName("system");
        user.setLastName("system");
        user.setRole(JobAppRole.ADMIN);
        userRepository.save(user);

        logger.info("-> User count: " + userRepository.count());
    }

    @Transactional
    public void seedJobPostings() {

        JobPosting jobPosting = new JobPosting();
        jobPosting.setDescription("test_description");
        jobPosting.setTitle("test_title");
        jobPostingRepository.save(jobPosting);

        logger.info("-> Job Posting count: " + jobPostingRepository.count());
    }
}
