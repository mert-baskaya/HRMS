package kodlamaio.hrms.entities.concretes.cvDetails.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EducationDto {

    @NotNull
    @NotBlank
    private int candidateId;

    @NotNull
    @NotBlank
    private int schoolId;

    @NotNull
    @NotBlank
    private int departmentId;

    @NotNull
    @NotBlank

    @NotNull
    @NotBlank
    private boolean isGraduated;

    @NotNull
    @NotBlank
    private Date entryDate;

    private Date graduationDate;

}
