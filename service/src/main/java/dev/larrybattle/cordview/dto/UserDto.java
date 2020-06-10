package dev.larrybattle.cordview.dto;

import dev.larrybattle.cordview.entity.JobAppRole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class UserDto {

    @Getter
    @Setter
    private boolean isActive;

    @Getter
    @Setter
    private boolean isInternal;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String company;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String companyNotes;

    @Getter
    @Setter
    private JobAppRole role;

    // standard methods
    @Getter
    @Setter
    private String globalId;

    @Getter
    private Date dateCreated;

    @Getter
    private Date lastUpdated;

}
