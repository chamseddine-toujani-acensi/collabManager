package fr.acensi.hrmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "mission")
public class Mission extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String description;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private MissionStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    private Company company;

    @OneToMany
    private Set<Collaborator> collaborators;

}