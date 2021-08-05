package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id")
    @JsonIgnore
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Transient
    private String passwordRepeat;

    @Column(name = "created_date")
    @JsonIgnore
    private String create_date;

    @Column(name = "is_activated",columnDefinition = "default false")
    @JsonIgnore //nasil aktive edilecegi konusunda soru isaretleri var
    private boolean isActivated;


}
