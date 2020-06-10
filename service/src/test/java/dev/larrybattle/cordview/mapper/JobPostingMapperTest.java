package dev.larrybattle.cordview.mapper;

import dev.larrybattle.cordview.dto.JobPostingDto;
import dev.larrybattle.cordview.entity.JobPosting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobPostingMapperTest {

    @DisplayName("test entity to dto")
    @Test
    public void testEntityToDto() {
        // setup
        String description = "test_description";
        String title = "test_title";
        JobPosting jobPosting = new JobPosting();
        jobPosting.setDescription(description);
        jobPosting.setTitle(title);

        JobPostingMapper jobPostingMapper = new JobPostingMapper();

        // when
        JobPostingDto dto = jobPostingMapper.map(jobPosting, JobPostingDto.class);

        // then
        assertEquals(title, dto.getTitle());
        assertEquals(description, dto.getDescription());
    }

    @DisplayName("test dto to entity")
    @Test
    public void testDtoToEntity() {
        // setup
        String description = "test_description";
        String title = "test_title";
        JobPostingDto dto = new JobPostingDto();
        dto.setDescription(description);
        dto.setTitle(title);

        JobPostingMapper jobPostingMapper = new JobPostingMapper();

        // when
        JobPosting entity = jobPostingMapper.map(dto, JobPosting.class);

        // then
        assertEquals(title, entity.getTitle());
        assertEquals(description, entity.getDescription());
    }
}
