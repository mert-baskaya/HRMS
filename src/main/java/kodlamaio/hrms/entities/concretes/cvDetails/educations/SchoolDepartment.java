package kodlamaio.hrms.entities.concretes.cvDetails.educations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "school_departments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SchoolDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int id;

    @NotNull
    @NotBlank
    private String departmentName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @JsonIgnore
    @ManyToMany(mappedBy = "schoolDepartments")
    private Set<School> schoolSet;
}
