package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.EmailChecker;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.validationServices.mailValidation.MailValidationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final UserDao userDao;

    private final EmployerDao employerDao;

    private final MailValidationService mailValidationService;

    //TODO staff validation service

    @Autowired
    public EmployerManager(UserDao userDao, EmployerDao employerDao, MailValidationService mailValidationService) {
        this.userDao = userDao;
        this.employerDao = employerDao;
        this.mailValidationService = mailValidationService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDao.findAll(), "Data getirildi");
    }

    @Override
    public Result add(Employer employer) {

        if(!nullControl(employer)) return new ErrorResult("Alanlar bos birakilamaz");

        if(!EmailChecker.checkEmail(employer.getUser().getEmail())) return new ErrorResult("Girilen email hatali");

        if(employerDao.existsByUser_Email(employer.getUser().getEmail())) return new ErrorResult("Email sisteme kaydolmus");

        if(!EmailChecker.checkEmailDomainConsistancy(employer.getWebAdress(), employer.getUser().getEmail())) return new ErrorResult("Email ile web adresi uyumlu degil");

        if(!mailValidationService.validate(employer.getUser().getEmail()).isSuccess()) return new ErrorResult("Mail dogrulamasi basarisiz");

        employer.getUser().setCreate_date(Long.toString(System.currentTimeMillis()));
        employerDao.save(employer);
        return new SuccessResult(employer.getUser().getEmail() + " : Sisteme kaydoldu");

    }

    @Override
    public Result approveEmployerByEmail(String email) {

        if(!userDao.existsByEmail(email)) return new ErrorResult("Girilen email sisteme kayitli degil");

        User user = userDao.getUserByEmail(email);

        user.setFrozen(false);

        userDao.saveAndFlush(user);

        return new SuccessResult("Kullanıcı aktive edildi: " + email);
    }

    private boolean nullControl(Employer employer){
        return employer.getUser().getEmail() != null &&
                employer.getUser().getPassword() != null &&
                employer.getUser().getPasswordRepeat() != null &&
                employer.getPhoneNumber() != null &&
                employer.getWebAdress() != null;
    }


}
