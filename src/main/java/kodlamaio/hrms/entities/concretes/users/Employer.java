package kodlamaio.hrms.entities.concretes.users;

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

    @Column(name = "web_adress")
    private String webAdress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_activated_by_staff")
    private boolean isActivatedByStaff;

    @OneToMany(mappedBy = "employer")
    private Set<JobPosting> jobPostings;

}
