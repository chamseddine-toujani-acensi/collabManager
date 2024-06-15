package fr.acensi.stuff.activity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue
    private Integer id;

    private String reference;

    private String description;

    @Enumerated(STRING)
    private paymentMethod paymentMethod;

    private String customerId;

    private String missionId;

    private String collaboratorId;

    private String EmployeeId;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDate creationDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDate lastUpdateDate;
}
