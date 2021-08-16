package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvDetails.jobExperiences.JobExperience;

import java.util.List;

public interface JobExperienceService {
    Result addJobExperience(JobExperience jobExperience, int candidateId);
    DataResult<List<JobExperience>> getJobExperiencesByCandidate_IdOrderByStartDateOfWorkStartDateOfWorkDesc(int candidateId);
}
