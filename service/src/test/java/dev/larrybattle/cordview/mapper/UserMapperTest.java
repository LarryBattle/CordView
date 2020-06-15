package dev.larrybattle.cordview.mapper;

import dev.larrybattle.cordview.dto.UserDto;
import dev.larrybattle.cordview.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {

    @DisplayName("test entity to dto")
    @Test
    public void testEntityToDto() {
        // setup
        String firstName = "test_firstName";
        String lastName = "test_lastName";
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        UserMapper mapper = new UserMapper();

        // when
        UserDto dto = mapper.map(user, UserDto.class);

        // then
        assertEquals(firstName, dto.getFirstName());
        assertEquals(lastName, dto.getLastName());
    }

    @DisplayName("test dto to entity")
    @Test
    public void testDtoToEntity() {
        // setup
        String firstName = "test_firstName";
        String lastname = "test_lastName";
        UserDto dto = new UserDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastname);

        UserMapper mapper = new UserMapper();

        // when
        User user = mapper.map(dto, User.class);

        // then
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastname, user.getLastName());
    }
}
