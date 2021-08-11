package kodlamaio.hrms.entities.concretes.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.JobPosting;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Employer extends User {

    private String companyName;

    private String webAdress;

    private String phoneNumber;

    private boolean isActivatedByStaff;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private Set<JobPosting> jobPostings;

}
