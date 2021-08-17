package kodlamaio.hrms.dataAccess.abstracts.cvs;

import kodlamaio.hrms.entities.concretes.cvs.jobExperiences.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    List<JobExperience> getJobExperiencesByCandidate_IdOrderByStartDateOfWorkDesc(int candidateId);

}
