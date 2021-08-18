package kodlamaio.hrms.entities.concretes.cvs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cover_letters")

public class CoverLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Ön yazı boş olamaz boş olamaz")
    private String summary;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;

}
