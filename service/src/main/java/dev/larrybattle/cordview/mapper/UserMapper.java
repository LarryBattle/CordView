package dev.larrybattle.cordview.mapper;

import dev.larrybattle.cordview.dto.UserDto;
import dev.larrybattle.cordview.entity.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;


public class UserMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(User.class, UserDto.class)
                .byDefault()
                .register();
    }
}
