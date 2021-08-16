package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvDetails.languages.Language;

public interface LanguageService {
    Result addLanguageToCandidate(Language language, int candidateId);
}
