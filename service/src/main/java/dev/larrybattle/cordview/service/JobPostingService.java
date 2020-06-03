package dev.larrybattle.cordview.service;

import dev.larrybattle.cordview.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JobPostingService {

    private JobPostingRepository repository;

    @Autowired
    public JobPostingService(JobPostingRepository repository){
        this.repository = repository;
    }
}

