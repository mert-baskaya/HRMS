package kodlamaio.hrms.entities.concretes.users;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Staff extends User {

    @Column(columnDefinition = "integer default 0")
    private int adminLevel;

}
