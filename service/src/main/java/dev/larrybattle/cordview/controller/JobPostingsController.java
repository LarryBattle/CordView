package dev.larrybattle.cordview.controller;

import dev.larrybattle.cordview.dto.JobPostingDto;
import dev.larrybattle.cordview.entity.Page;
import dev.larrybattle.cordview.service.JobPostingSearchOptions;
import dev.larrybattle.cordview.service.JobPostingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping(path = "/jobs", consumes = {MediaType.APPLICATION_JSON_VALUE})
public class JobPostingsController {

    @Autowired
    JobPostingService jobPostingService;

    @GetMapping
    public Page<JobPostingDto> index() {
        JobPostingSearchOptions options = new JobPostingSearchOptions(10);

        Page<JobPostingDto> page = jobPostingService.search(options);
        log.info("method:'index()' options:'{}' type:'jobs' count:'{}', total:'{}'", options, page.getCount(), page.getTotal());
        return page;
    }

    // TODO Add validation support
    @PostMapping
    public JobPostingDto create(@RequestBody JobPostingDto dto) {
        log.info("method:create() creating dto: {}", dto);

        JobPostingDto savedDto = null;

        try {
            savedDto = jobPostingService.create(dto);
        } catch (Exception ex) {
            log.error("Unable to create job posting", ex);
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Unable to create job posting", ex);
        }

        return savedDto;
    }

    public static class PageJobPostingDto extends Page<JobPostingDto> {
    }
}
