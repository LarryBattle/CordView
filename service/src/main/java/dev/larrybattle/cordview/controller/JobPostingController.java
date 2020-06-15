package dev.larrybattle.cordview.controller;

import dev.larrybattle.cordview.dto.JobPostingDto;
import dev.larrybattle.cordview.service.JobPostingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin()
@RestController
@RequestMapping(path = "/jobs/{jobGlobalId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
public class JobPostingController {

    @Autowired
    JobPostingService jobPostingService;

    @GetMapping
    public JobPostingDto index(@PathVariable String jobGlobalId) {
        JobPostingDto dto = jobPostingService.get(jobGlobalId);
        log.info("method:'index()' type:jobs globalId:'{}' found:{}", jobGlobalId, dto == null);
        return dto;
    }

    @PutMapping
    public JobPostingDto update(@PathVariable String jobGlobalId, @RequestBody JobPostingDto dto) {
        JobPostingDto savedDto = jobPostingService.update(jobGlobalId, dto);
        log.info("method:'update()' type:jobs globalId:'{}' savedDto:{}", jobGlobalId, dto);
        return savedDto;
    }

    @DeleteMapping
    public ResponseEntity<String> deleteJob(@PathVariable String jobGlobalId) {
        boolean didDelete = jobPostingService.disable(jobGlobalId);

        log.info("method:'deleteJob()' type:jobs globalId:'{}' didDelete:{}", jobGlobalId, didDelete);
        if (didDelete) {
            return new ResponseEntity<>(jobGlobalId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobGlobalId, HttpStatus.ACCEPTED);
    }

}
