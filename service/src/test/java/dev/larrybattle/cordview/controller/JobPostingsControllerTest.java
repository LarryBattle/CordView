package dev.larrybattle.cordview.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static dev.larrybattle.cordview.controller.JobPostingsController.PageJobPostingDto;
import static org.assertj.core.api.Assertions.assertThat;

// Guide: https://spring.io/guides/gs/testing-web/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobPostingsControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testJobsEndpoint() {
        // when
        PageJobPostingDto jobs = this.restTemplate.getForObject("http://localhost:" + port + "/jobs", PageJobPostingDto.class);

        // then
        assertThat(jobs).isNotNull();
        assertThat(jobs.getTotal()).isPositive();
    }
}

