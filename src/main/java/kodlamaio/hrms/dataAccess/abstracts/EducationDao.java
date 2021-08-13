package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.cvDetails.educations.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    boolean existsSchoolDetailByCandidate_Id(int candidateId);

    boolean existsSchoolDetailBySchool_Id(int schoolId);

    List<Education> getSchoolDetailsByCandidate_Id(int candidateId);

    List<Education> getSchoolDetailsBySchool_Id(int schoolId);

}
