package dev.larrybattle.cordview.mapper;

import dev.larrybattle.cordview.dto.JobPostingDto;
import dev.larrybattle.cordview.entity.JobPosting;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;


public class JobPostingMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory){
        mapperFactory.classMap(JobPosting.class, JobPostingDto.class)
            .byDefault()
            .register();
    }
}
