package kodlamaio.hrms.entities.concretes.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobPostingDto {

    // Burada front-end bize id mi yollayacak yoksa veri mi yollayacak?

    // Bence iki tipte de veri kabul edilebilmeli ama
    // dropdown menüden seçilecekse zaten tüm verileri seçmiş olacaktır (id ile girmek daha mantıklı olur)
    // Front-end bize hali hazırda seçilmiş olan bir employer ile iş kaydı yapacağı için sadece id'ler ile
    // yapmak daha mantıklı gibi görünüyor

    //private String jobPosition;
    //private String cityName;
    //private String companyName;

    @NotNull
    private int jobPositionId;

    @NotNull
    private int cityId;

    @NotNull
    private int employerID;

    @NotBlank
    private String jobDescription;

    private String salaryMin;
    private String salaryMax;
    private String salary;

    @NotNull
    @Min(value = 1, message = "En az 1 açık pozisyon olmalı")
    private int openPositions;

    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date applicationDeadline;

    @JsonIgnore
    private boolean isActive = true;

}
