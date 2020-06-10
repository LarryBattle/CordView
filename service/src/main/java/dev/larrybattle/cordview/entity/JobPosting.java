package dev.larrybattle.cordview.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

// TODO Add the following
// Set<User> subscribers; // when doing APP_SUBMIT_REVIEWER
// Set<JobApplicant> jobApplicants; // when doing JOB_SUBMITTER tasks
@Table(name = "job_posting",
        indexes = {@Index(name = "idx_job_posting_global_id", columnList = "global_id", unique = true)
})
@Entity
public class JobPosting {
    @NotNull
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private JobPostingState state = JobPostingState.DRAFT;

    @Id
    @GeneratedValue
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @NotBlank
    @Size(max = 70)
    @Getter
    @Setter
    private String title;

    @NotBlank
    @Size(max = 5000)
    @Getter
    @Setter
    private String description;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private WageType wageType;

    // TODO Store an wageAmount as Hibernate Currency
    // https://stackoverflow.com/questions/29619958/how-to-persist-classes-like-java-util-currency
    // TODO Add a positive or zero constraint once the data type is converted
    @Getter
    @Setter
    private String wageAmount;

    @Getter
    @Setter
    private boolean isActive;

    @Getter
    @Setter
    private String internalNotes;

    // https://www.baeldung.com/jpa-one-to-one
    // TODO https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
//    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", referencedColumnName = "id")
    @Getter
    @Setter
    private User createdBy;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_by_id", referencedColumnName = "id")
    @Getter
    @Setter
    private User owner;

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
