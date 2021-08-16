package kodlamaio.hrms.business.concretes.cvs;

import kodlamaio.hrms.business.abstracts.cvs.LanguageService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvs.LanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.cvs.languages.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;
    private final CandidateDao candidateDao; //Bunları UserDao'dan çekmek ileriye dönük olarak daha mantıklı olur

    @Autowired
    public LanguageManager(LanguageDao languageDao, CandidateDao candidateDao) {
        this.languageDao = languageDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result addLanguageToCandidate(Language language, int candidateId) {
        if(candidateDao.existsById(candidateId)){
            language.setCandidate(candidateDao.getById(candidateId));
            languageDao.save(language);
            return new SuccessResult("Kaydedildi");
        }else{
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }
}
