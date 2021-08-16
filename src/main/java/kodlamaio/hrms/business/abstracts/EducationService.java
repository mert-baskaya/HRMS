package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvDetails.educations.Education;

import java.util.List;

public interface EducationService {
    Result addEducation(Education education, int candidateId);
    DataResult<List<Education>> getEducationsByCandidate_IdOrderByEntryDateDesc(int candidateId);
}
