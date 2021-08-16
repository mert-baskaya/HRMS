package kodlamaio.hrms.business.abstracts.cvs;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.educations.Education;

import java.util.List;

public interface EducationService {
    Result addEducation(Education education, int candidateId);
    DataResult<List<Education>> getEducationsByCandidate_IdOrderByEntryDateDesc(int candidateId);
}
