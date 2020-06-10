package dev.larrybattle.cordview.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user",
    indexes = {
            @Index(name = "idx_user_global_id", columnList = "global_id", unique = true),
            @Index(name = "idx_user_f_l_name", columnList = "first_name,last_name"),
})
public class User {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private boolean isActive;

    @Getter
    @Setter
    private boolean isInternal;

    @NotNull
    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @NotNull
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

    @Enumerated(EnumType.STRING)
    @NotNull
    @Getter
    @Setter
    private JobAppRole role = JobAppRole.VISITOR;

    // standard methods
    @Getter
    @Setter
    @Column(name="global_id")
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
