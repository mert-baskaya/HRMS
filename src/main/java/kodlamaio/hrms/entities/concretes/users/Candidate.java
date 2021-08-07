package kodlamaio.hrms.entities.concretes.users;

import kodlamaio.hrms.entities.concretes.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity_number")
    private String nationalIdentityNumber;

    @Column(name = "birth_year")
    private String birthYear;

}
