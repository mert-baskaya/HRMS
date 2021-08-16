package kodlamaio.hrms.entities.concretes.cvs;

import kodlamaio.hrms.core.entites.User;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime uploadDateTime;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
