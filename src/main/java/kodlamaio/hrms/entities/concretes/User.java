package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email; //sql date aliyor test etmek lazim

    @Column(name = "password")
    private String password;

    private String passwordRepeat;

    @Column(name = "created_date")
    private String create_date;

    @Column(name = "is_activated")
    private boolean isActivated;

}
