package dev.larrybattle.cordview.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.UUID;

// TODO Add the following
// Set<User> subscribers; // when doing APP_SUBMIT_REVIEWER
// Set<JobApplicant> jobApplicants; // when doing JOB_SUBMITTER tasks
@Table(name = "job_posting",
        indexes = {@Index(name = "idx_job_posting_global_id", columnList = "global_id", unique = true)
})
@Data
@Entity
public class JobPosting {
    public JobPosting() {
    }

    public JobPosting(String title, String description, String location, String wageAmount, WageType wageType) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.wageAmount = wageAmount;
        this.wageType = wageType;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    private JobPostingState state = JobPostingState.DRAFT;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 70)
    private String title;

    // assume markdown as fileformat
    @NotBlank
    @Size(max = 5000)
    private String description;

    @NotBlank
    private String location;

    @Enumerated(EnumType.STRING)
    private WageType wageType;

    // TODO Store an wageAmount as BigDecimal or Hibernate Currency
    // https://stackoverflow.com/questions/29619958/how-to-persist-classes-like-java-util-currency
    // TODO Add a positive or zero constraint once the data type is converted
    private String wageAmount;

    private boolean isActive;
    private String internalNotes;

    // https://www.baeldung.com/jpa-one-to-one
    // TODO https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
//    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", referencedColumnName = "id")
    private User createdBy;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_by_id", referencedColumnName = "id")
    private User owner;

    // standard methods
    @Column(name="global_id")
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
