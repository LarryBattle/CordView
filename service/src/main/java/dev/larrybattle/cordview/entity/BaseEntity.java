package dev.larrybattle.cordview.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class BaseEntity {

//    @NotBlank
    @Getter
    @Setter
    private String globalId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date dateCreated;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date lastUpdated;

    @PrePersist
    public void onPrePersist() {
        if (globalId == null) {
            globalId = UUID.randomUUID().toString();
        }
    }

}
