package dev.larrybattle.cordview.dto;

import dev.larrybattle.cordview.entity.JobAppRole;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private boolean isActive;
    private boolean isInternal;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phone;
    private String companyNotes;
    private JobAppRole role;
    private String globalId;
    private Date dateCreated;
    private Date lastUpdated;

}
