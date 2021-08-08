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

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_adress")
    private String webAdress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_activated_by_staff")
    private boolean isActivatedByStaff;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private Set<JobPosting> jobPostings;

}
