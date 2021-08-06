package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonIgnore
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // TODO istenmeyen bir field'ın GET'te görünmesini engellemenin bir yolunu bul
    @Transient
    private String passwordRepeat;

    @Column(name = "created_date")
    @JsonIgnore
    private String create_date;

    @Column(name = "is_frozen",columnDefinition = "default = true")
    @JsonIgnore //nasil aktive edilecegi konusunda soru isaretleri var
    private boolean isFrozen;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Staff> staff = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Candidate> candidates = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Employer> employers = new ArrayList<>();

}
