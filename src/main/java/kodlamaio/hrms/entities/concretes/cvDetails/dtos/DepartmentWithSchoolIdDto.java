package kodlamaio.hrms.entities.concretes.cvDetails.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentWithSchoolIdDto {

    private int schoolId;
    private String departmentName;

}
