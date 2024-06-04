package fr.acensi.stuff.company;

import fr.acensi.stuff.model.AbstractEntity;
import fr.acensi.stuff.account.Account;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;

    @OneToMany
    private Set<Account> representatives;

}