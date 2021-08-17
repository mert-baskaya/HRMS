package kodlamaio.hrms.business.abstracts.cvs;

import kodlamaio.hrms.core.utilities.results.Result;

public interface CoverLetterService {
    Result add(String summary, int candidateId);
}
