package kodlamaio.hrms.entities.concretes.cvs.jobExperiences;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "job_experiences")
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;

    @NotBlank(message = "Firma ismi boş olamaz")
    private String companyName;

    @NotBlank(message = "İş pozisyonu boş olamaz")
    private String jobPosition;

    @NotNull(message = "İşe giriş tarihi boş olamaz (örn: 2021-08-16)")
    @Column(columnDefinition = "DATE")
    private LocalDate startDateOfWork;

    @Column(columnDefinition = "DATE")
    private LocalDate dismissalDate;

    @NotNull(message = "İş çıkış bilgisi boş olamaz (örn: true veya false)")
    private boolean isDismissed;

}
