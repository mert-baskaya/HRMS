package kodlamaio.hrms.business.abstracts.cvs;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.languages.Language;

import java.util.List;

public interface LanguageService {
    Result addLanguageToCandidate(Language language, int candidateId);

    DataResult<List<Language>> getByUserId(int userId);
}
