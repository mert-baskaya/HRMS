package kodlamaio.hrms.business.abstracts.cvs;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.languages.Language;

public interface LanguageService {
    Result addLanguageToCandidate(Language language, int candidateId);
}
