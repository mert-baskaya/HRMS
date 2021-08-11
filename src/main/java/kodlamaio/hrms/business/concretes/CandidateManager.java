package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.EmailChecker;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.validationServices.mailValidation.MailValidationService;
import kodlamaio.hrms.core.validationServices.userValidation.UserNationalIdValidationService;
import kodlamaio.hrms.dataAccess.abstracts.users.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private final UserDao userDao;
    private final UserNationalIdValidationService nationalIdValidationService;
    private final MailValidationService mailValidationService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserDao userDao, UserNationalIdValidationService nationalIdValidationService, MailValidationService mailValidationService) {
        this.candidateDao = candidateDao;
        this.userDao = userDao;
        this.nationalIdValidationService = nationalIdValidationService;
        this.mailValidationService = mailValidationService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll(), "Data getirildi");
    }

    @Override
    public Result add(Candidate candidate) {

        if(!nullControl(candidate)) return new ErrorResult("Alanlar bos birakilamaz");

        if(!EmailChecker.checkEmail(candidate.getEmail())) return new ErrorResult("Girilen email hatali");

        if(userDao.existsUserByEmail(candidate.getEmail())) return new ErrorResult("Email sisteme daha önce kaydolmuş");

        if(candidateDao.existsCandidateByNationalIdentityNumber(candidate.getNationalIdentityNumber())) return new ErrorResult("Kimlik numarasi sisteme daha önce kaydolmus");

        if(!nationalIdValidationService.validate(candidate.getNationalIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear()).isSuccess()) return new ErrorResult("Kullanici kimligi dogrulanamadi");

        if(!mailValidationService.validate(candidate.getEmail()).isSuccess()) return new ErrorResult("Mail dogrulamasi basarisiz");

        candidate.setCreateDate(Long.toString(System.currentTimeMillis()));
        candidateDao.save(candidate);
        return new SuccessResult(candidate.getEmail() + " : Sisteme kaydoldu");

    }

    private boolean nullControl(Candidate candidate) {
        return candidate.getFirstName() != null &&
                candidate.getLastName() != null &&
                candidate.getNationalIdentityNumber() != null &&
                candidate.getBirthYear() != null &&
                candidate.getPasswordRepeat() != null;
    }

}
