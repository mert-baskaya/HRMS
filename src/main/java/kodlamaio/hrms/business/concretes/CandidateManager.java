package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.DateTimeClass;
import kodlamaio.hrms.core.utilities.EmailChecker;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.validationServices.mailValidation.MailValidationService;
import kodlamaio.hrms.core.validationServices.userValidation.UserNationalIdValidationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private UserNationalIdValidationService nationalIdValidationService;
    private MailValidationService mailValidationService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserNationalIdValidationService nationalIdValidationService, MailValidationService mailValidationService) {
        this.candidateDao = candidateDao;
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

        if(!EmailChecker.checkEmail(candidate.getEmail())) return new ErrorResult("Girilen email hatali"); // validation servislerinde polimorphism kullanilmali

        if(candidateDao.existsByEmail(candidate.getEmail())) return new ErrorResult("Email sisteme kaydolmus");

        if(candidateDao.existsByNationalIdentityNumber(candidate.getNationalIdentityNumber())) return new ErrorResult("Tc kimlik numarasi sisteme kaydolmus");

        if(!nationalIdValidationService.validate(candidate.getNationalIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear()).isSuccess()) return new ErrorResult("Kullanici kimligi dogrulanamadi");

        if(!mailValidationService.validate(candidate.getEmail()).isSuccess()) return new ErrorResult("Mail dogrulamasi basarisiz");


        candidate.setCreate_date(Long.toString(System.currentTimeMillis()));
        candidateDao.save(candidate);
        return new SuccessResult(candidate.getEmail() + " : Sisteme kaydoldu");
    }

    private boolean nullControl(Candidate candidate) {
        if (candidate.getFirstName() == null ||
                candidate.getLastName() == null ||
                candidate.getNationalIdentityNumber() == null ||
                candidate.getBirthYear() == null ||
                candidate.getEmail() == null ||
                candidate.getPassword() == null ||
                candidate.getPasswordRepeat() == null) {
            return false;
        }
        return true;
    }
}
