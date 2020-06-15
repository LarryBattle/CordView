package dev.larrybattle.cordview.controller;

import dev.larrybattle.cordview.dto.JobPostingDto;
import dev.larrybattle.cordview.entity.Page;
import dev.larrybattle.cordview.service.JobPostingSearchOptions;
import dev.larrybattle.cordview.service.JobPostingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/jobs")
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

    public static class PageJobPostingDto extends Page<JobPostingDto>{}

}
