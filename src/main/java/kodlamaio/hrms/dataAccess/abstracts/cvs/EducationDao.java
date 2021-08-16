package kodlamaio.hrms.dataAccess.abstracts.cvs;

import kodlamaio.hrms.entities.concretes.cvs.educations.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    List<Education> getEducationsByCandidate_IdOrderByEntryDateDesc(int candidateId);

}
