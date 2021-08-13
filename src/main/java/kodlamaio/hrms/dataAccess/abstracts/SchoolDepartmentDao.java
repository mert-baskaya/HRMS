package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.cvDetails.educations.SchoolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer> {

    List<SchoolDepartment> getSchoolDepartmentsBySchool_Id(int schoolId);

}
