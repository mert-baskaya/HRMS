package kodlamaio.hrms.entities.concretes.cvs.links;

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
@Table(name = "github_links")

public class GithubLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Github url'i boş olamaz")
    private String url; //TODO Github linki url olarak nasıl alınabilir

    @OneToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;

}
