package kodlamaio.hrms.entities.concretes.cvDetails.educations;

import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "school_department_id")
    private SchoolDepartment schoolDepartment;

    @NotNull
    @NotBlank
    private boolean isGraduated;

    @NotNull
    @NotBlank
    private Date entryDate;

    @NotNull
    private Date graduationDate;

}
