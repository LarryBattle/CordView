package dev.larrybattle.cordview.dto;

import dev.larrybattle.cordview.entity.JobPostingState;
import dev.larrybattle.cordview.entity.User;
import dev.larrybattle.cordview.entity.WageType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class JobPostingDto {
    @Getter
    @Setter
    private JobPostingState state;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private WageType wageType;

    @Getter
    @Setter
    private String wageAmount;

    @Getter
    @Setter
    private boolean isActive;

    @Getter
    @Setter
    private String internalNotes;

    @Getter
    @Setter
    private User createdBy;

    @Getter
    @Setter
    private User owner;

    // standard methods
    @Getter
    private String globalId;

    @Getter
    private Date dateCreated;

    @Getter
    private Date lastUpdated;

}
