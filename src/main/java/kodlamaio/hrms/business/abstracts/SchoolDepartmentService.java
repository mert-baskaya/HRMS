package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvDetails.dtos.DepartmentWithSchoolIdDto;
import kodlamaio.hrms.entities.concretes.cvDetails.educations.SchoolDepartment;

import java.util.List;

public interface SchoolDepartmentService {

    Result add(DepartmentWithSchoolIdDto departmentWithSchoolIdDto);

    DataResult<SchoolDepartment> getById(int id);

    DataResult<List<SchoolDepartment>> getAllBySchoolId(int schoolId);

}
