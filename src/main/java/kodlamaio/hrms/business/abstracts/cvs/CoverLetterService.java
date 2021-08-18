package kodlamaio.hrms.business.abstracts.cvs;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;

public interface CoverLetterService {
    Result add(String summary, int candidateId);

    DataResult<CoverLetter> getByUSerId(int userId);
}
