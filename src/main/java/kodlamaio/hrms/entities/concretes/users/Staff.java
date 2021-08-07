package kodlamaio.hrms.entities.concretes.users;

import kodlamaio.hrms.entities.concretes.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Staff extends User {

    @Column(name = "admin_level", columnDefinition = "integer default 0")
    private int adminLevel;

}
