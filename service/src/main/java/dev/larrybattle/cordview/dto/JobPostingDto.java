package dev.larrybattle.cordview.dto;

import dev.larrybattle.cordview.entity.JobPostingState;
import dev.larrybattle.cordview.entity.User;
import dev.larrybattle.cordview.entity.WageType;
import lombok.Data;

import java.util.Date;

@Data
public class JobPostingDto {
    private JobPostingState state;
    private String title;
    private String description;
    private String location;
    private WageType wageType;
    private String wageAmount;
    private boolean isActive;
    private String internalNotes;
    private User createdBy;
    private User owner;
    private String globalId;
    private Date dateCreated;
    private Date lastUpdated;

}
