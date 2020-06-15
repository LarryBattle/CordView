package dev.larrybattle.cordview.mapper;

import dev.larrybattle.cordview.dto.JobPostingDto;
import dev.larrybattle.cordview.entity.JobPosting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    @DisplayName("test dto can't update restricted fields to entity")
    @Test
    public void testDtoCanNotUpdateRestrictedFieldsToEntity() {
        // setup
        String globalId = "test_globalId";
        Date dateCreated = new Date();
        JobPostingDto dto = new JobPostingDto();
        dto.setGlobalId(globalId);
        dto.setDateCreated(dateCreated);
        dto.setLastUpdated(dateCreated);

        JobPostingMapper jobPostingMapper = new JobPostingMapper();

        // when
        JobPosting entity = jobPostingMapper.map(dto, JobPosting.class);

        // then
        assertNull(entity.getGlobalId());
        assertNull(entity.getDateCreated());
        assertNull(entity.getLastUpdated());
    }

}
