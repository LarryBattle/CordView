package dev.larrybattle.cordview.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "user",
        indexes = {
                @Index(name = "idx_user_global_id", columnList = "global_id", unique = true),
                @Index(name = "idx_user_f_l_name", columnList = "first_name,last_name")
        })
public class User {
    public User(){}
    public User(String firstName, String lastName, String email, String company, JobAppRole role, boolean isActive){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.isActive = isActive;
        this.company = company;
    }
    @Id
    @GeneratedValue
    private Long id;
    private boolean isActive;
    private boolean isInternal;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    private String company;
    private String email;
    private String phone;
    private String companyNotes;

    @Enumerated(EnumType.STRING)
    @NotNull
    private JobAppRole role = JobAppRole.VISITOR;

    // standard methods
    @Column(name = "global_id")
    private String globalId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @PrePersist
    public void onPrePersist() {
        if (globalId == null) {
            globalId = UUID.randomUUID().toString();
        }
    }

}
