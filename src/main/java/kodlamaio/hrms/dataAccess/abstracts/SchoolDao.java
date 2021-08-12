package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.cvDetails.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School, Integer> {

    boolean existsBySchoolName(String schoolName);

    School getBySchoolName(String schoolName);

}
