package fr.acensi.stuff.collaborator;

import fr.acensi.stuff.model.AbstractEntity;
import fr.acensi.stuff.account.Account;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "collaborator")
public class Collaborator extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zip;
}
