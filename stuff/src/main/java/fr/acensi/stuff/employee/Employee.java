package fr.acensi.stuff.employee;


import fr.acensi.stuff.account.Account;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee{
    @Id
    @GeneratedValue
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
