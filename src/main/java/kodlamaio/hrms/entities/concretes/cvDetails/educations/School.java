package kodlamaio.hrms.entities.concretes.cvDetails.educations;

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

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "school_department_join",
    joinColumns = @JoinColumn(name = "school_id"),
    inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<SchoolDepartment> schoolDepartments;

}
