package dev.larrybattle.cordview.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;


// TODO Add indexes
@Entity
public class JobPosting {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 70)
    private String title;

    @NotBlank
    @Size(max = 5000)
    private String description;

    @Enumerated(EnumType.STRING)
    private WageType wageType;

    // TODO Store an wageAmount as Hibernate Currency
    // https://stackoverflow.com/questions/29619958/how-to-persist-classes-like-java-util-currency
    // TODO Add a positive or zero constraint once the data type is converted
    private String wageAmount;

    // https://www.baeldung.com/jpa-one-to-one
    // TODO https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
//    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "createdBy_id", referencedColumnName = "id")
    private User createdBy;
}
