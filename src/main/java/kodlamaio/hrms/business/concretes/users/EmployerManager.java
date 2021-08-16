package kodlamaio.hrms.business.concretes.users;

import kodlamaio.hrms.business.abstracts.users.EmployerService;
import kodlamaio.hrms.core.utilities.EmailChecker;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.validationServices.mailValidation.MailValidationService;
import kodlamaio.hrms.dataAccess.abstracts.users.EmployerDao;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.users.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;
    private final UserDao userDao;
    private final MailValidationService mailValidationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserDao userDao, MailValidationService mailValidationService) {
        this.employerDao = employerDao;
        this.userDao = userDao;
        this.mailValidationService = mailValidationService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDao.findAll(), "Data getirildi");
    }

    @Override
    public DataResult<Employer> getEmployerByCompanyName(String companyName) {
        if(!employerDao.existsByCompanyName(companyName)) return new ErrorDataResult<>(companyName + " Sistemde kayıtlı değil");
        else return new SuccessDataResult<>(employerDao.getByCompanyName(companyName));
    }

    @Override
    public Result add(Employer employer) {

        if(!nullControl(employer)) return new ErrorResult("Alanlar bos birakilamaz");

        if(!EmailChecker.checkEmail(employer.getEmail())) return new ErrorResult("Girilen email hatali");

        if(userDao.existsUserByEmail(employer.getEmail())) return new ErrorResult("Email sisteme daha önce kaydolmuş");

        if(!EmailChecker.checkEmailDomainConsistancy(employer.getWebAdress(), employer.getEmail())) return new ErrorResult("Email ile web adresi uyumlu degil");

        if(!mailValidationService.validate(employer.getEmail()).isSuccess()) return new ErrorResult("Mail dogrulamasi basarisiz");

        employer.setCreateDate(Long.toString(System.currentTimeMillis()));
        employerDao.save(employer);
        return new SuccessResult(employer.getEmail() + " : Sisteme kaydoldu");

    }

    @Override
    public Result approveEmployerByEmail(String email) {

        if(!employerDao.existsByEmail(email)) return new ErrorResult("Email sisteme kayitli degil");

        Employer employer = employerDao.getByEmail(email);

        employer.setActivatedByStaff(true);

        employerDao.save(employer);

        return new SuccessResult("Aktivasyon basarili");
    }

    private boolean nullControl(Employer employer){
        return employer.getPasswordRepeat() != null &&
                employer.getPhoneNumber() != null &&
                employer.getWebAdress() != null;
    }


}
