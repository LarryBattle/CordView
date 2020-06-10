package dev.larrybattle.cordview.service;

import dev.larrybattle.cordview.dto.JobPostingDto;
import dev.larrybattle.cordview.entity.JobPosting;
import dev.larrybattle.cordview.mapper.JobPostingMapper;
import dev.larrybattle.cordview.repository.JobPostingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class JobPostingService {

    private JobPostingRepository repository;

    @Autowired
    public JobPostingService(JobPostingRepository repository){
        this.repository = repository;
    }

    private final JobPostingMapper mapper = new JobPostingMapper();

    public JobPostingDto get(String globalId){
        JobPostingDto dto = null;

        try {
            JobPosting entity = repository.findByGlobalId(globalId);
            dto = mapper.map(entity, JobPostingDto.class);
        }catch(Exception e){
            log.error(String.format("Unable to find JobPosting by globalId: %s", globalId));
        }
        return dto;
    }
    /**
     *
     *     JobPostingDto get(String globalId);
     *     JobPostingDto create(JobPostingDto jobPosting);
     *     JobPostingDto update(String globalId, JobPostingDto jobPosting);
     *     boolean disable(String globalId);
     *     Page<JobPostingDto> search(SearchOptions options);
     *
     *     */
}

