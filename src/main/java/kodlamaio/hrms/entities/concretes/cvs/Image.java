package kodlamaio.hrms.entities.concretes.cvs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.core.entites.User;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "images")

public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;

    private String publicId;

    //https://www.baeldung.com/java-zone-offset
    private ZonedDateTime uploadDateTime;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;

}
