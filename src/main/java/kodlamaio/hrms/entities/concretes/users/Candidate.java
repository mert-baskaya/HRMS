package kodlamaio.hrms.entities.concretes.users;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Candidate extends User {

    private String firstName;

    private String lastName;

    private String nationalIdentityNumber;

    private String birthYear;

}
