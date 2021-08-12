package kodlamaio.hrms.entities.concretes.cvDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private int id;

    @NotNull
    @NotBlank
    private String schoolName;

    @NotNull
    @NotBlank
    private String division;

    @OneToMany(mappedBy = "school")
    private Set<SchoolDetail> schoolDetails;

    //TODO okul detayı ekleme

}
