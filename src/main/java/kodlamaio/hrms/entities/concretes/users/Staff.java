package kodlamaio.hrms.entities.concretes.users;

import kodlamaio.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Staff extends User {

    private int administrationLevel;

}
