package kodlamaio.hrms.dataAccess.abstracts.users;

import kodlamaio.hrms.entities.concretes.cvDetails.jobExperiences.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    List<JobExperience> getJobExperiencesByCandidate_IdOrderByStartDateOfWorkDesc(int candidateId);

}
