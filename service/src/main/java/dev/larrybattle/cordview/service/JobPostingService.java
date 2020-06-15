package dev.larrybattle.cordview.service;

import dev.larrybattle.cordview.dto.JobPostingDto;
import dev.larrybattle.cordview.entity.JobPosting;
import dev.larrybattle.cordview.entity.Page;
import dev.larrybattle.cordview.mapper.JobPostingMapper;
import dev.larrybattle.cordview.repository.JobPostingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JobPostingService {

    private final JobPostingMapper mapper = new JobPostingMapper();
    private final JobPostingRepository repository;

    @Autowired
    public JobPostingService(JobPostingRepository repository) {
        this.repository = repository;
    }

    public JobPostingDto get(@NonNull String globalId) {
        Objects.requireNonNull(globalId);
        JobPostingDto dto = null;

        try {
            JobPosting entity = repository.findByGlobalId(globalId);
            dto = mapper.map(entity, JobPostingDto.class);
        } catch (Exception e) {
            log.error(String.format("Unable to find JobPosting by globalId: %s", globalId), e);
        }
        return dto;
    }

    public JobPostingDto create(@NonNull JobPostingDto dto) {
        Objects.requireNonNull(dto);

        JobPostingDto savedDto = null;

        try {
            JobPosting entity = mapper.map(dto, JobPosting.class);
            JobPosting savedEntity = repository.save(entity);
            savedDto = mapper.map(savedEntity, JobPostingDto.class);
        } catch (Exception e) {
            log.error("Unable to create JobPosting", e);
            throw e;
        }

        return savedDto;
    }

    public JobPostingDto update(@NonNull String globalId, @NonNull JobPostingDto dto) {
        Objects.requireNonNull(globalId);
        Objects.requireNonNull(dto);

        JobPostingDto savedDto = null;

        try {
            JobPosting entity = repository.findByGlobalId(globalId);
            if (entity == null) {
                return null;
            }
            mapper.map(dto, entity);
            JobPosting savedEntity = repository.save(entity);
            savedDto = mapper.map(savedEntity, JobPostingDto.class);
        } catch (Exception e) {
            log.error("Unable to create JobPosting", e);
        }

        return savedDto;
    }

    public boolean disable(@NonNull String globalId) {
        Objects.requireNonNull(globalId);
        boolean success = false;

        try {
            JobPosting entity = repository.findByGlobalId(globalId);
            if (entity == null) {
                return false;
            }
            entity.setActive(false);
            repository.save(entity);
            success = true;
        } catch (Exception e) {
            log.error("Unable to update JobPosting", e);
        }

        return success;
    }

    // TODO Add search
    public Page<JobPostingDto> search(@NonNull JobPostingSearchOptions options) {
        Objects.requireNonNull(options);

        log.debug("TODO: implement search");

        Page<JobPostingDto> page = new Page<>();
        List<JobPosting> entities = repository.findAll();

        if (0 < entities.size()) {
            List<JobPostingDto> dtos = entities.stream()
                    .map(job -> mapper.map(job, JobPostingDto.class))
                    .collect(Collectors.toList());

            page.setContent(dtos);
            page.setCount(dtos.size());
            page.setTotal(dtos.size());
        }

        return page;
    }
}

