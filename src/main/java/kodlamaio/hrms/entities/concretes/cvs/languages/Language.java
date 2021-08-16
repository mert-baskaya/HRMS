package kodlamaio.hrms.entities.concretes.cvs.languages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "languages")

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;

    @NotBlank(message = "İsim boş olamaz")
    private String name;

    @NotNull(message = "Dil seviyesi boş olamaz")
    @Range(min = 1, max = 5, message = "Dil seviyesi 1 ile 5 arasında olmalı")
    private int level;

}
