package kodlamaio.hrms.business.concretes.users;

import kodlamaio.hrms.business.abstracts.cvs.*;
import kodlamaio.hrms.business.abstracts.cvs.links.GithubLinkService;
import kodlamaio.hrms.business.abstracts.cvs.links.SocialLinkService;
import kodlamaio.hrms.business.abstracts.users.CandidateService;
import kodlamaio.hrms.core.utilities.EmailChecker;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.validationServices.mailValidation.MailValidationService;
import kodlamaio.hrms.core.validationServices.userValidation.UserNationalIdValidationService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.cvs.dtos.CVWithCandidateDto;
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

    private final EducationService educationService;
    private final JobExperienceService jobExperienceService;
    private final LanguageService languageService;
    private final GithubLinkService githubLinkService;
    private final SocialLinkService socialLinkService;
    private final TechnicalSkillService technicalSkillService;
    private final CoverLetterService coverLetterService;
    private final ImageService imageService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserDao userDao, UserNationalIdValidationService nationalIdValidationService, MailValidationService mailValidationService, EducationService educationService, JobExperienceService jobExperienceService, LanguageService languageService, GithubLinkService githubLinkService, SocialLinkService socialLinkService, TechnicalSkillService technicalSkillService, CoverLetterService coverLetterService, ImageService imageService) {
        this.candidateDao = candidateDao;
        this.userDao = userDao;
        this.nationalIdValidationService = nationalIdValidationService;
        this.mailValidationService = mailValidationService;
        this.educationService = educationService;
        this.jobExperienceService = jobExperienceService;
        this.languageService = languageService;
        this.githubLinkService = githubLinkService;
        this.socialLinkService = socialLinkService;
        this.technicalSkillService = technicalSkillService;
        this.coverLetterService = coverLetterService;
        this.imageService = imageService;
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        if(candidateDao.findById(id).isPresent()){
            return new SuccessDataResult<>(candidateDao.getById(id));
        }else{
            return new ErrorDataResult<>("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll(), "Data getirildi");
    }

    @Override
    public Result add(Candidate candidate) {

        if (!nullControl(candidate)) return new ErrorResult("Alanlar bos birakilamaz");

        if (!EmailChecker.checkEmail(candidate.getEmail())) return new ErrorResult("Girilen email hatali");

        if (userDao.existsUserByEmail(candidate.getEmail()))
            return new ErrorResult("Email sisteme daha önce kaydolmuş");

        if (candidateDao.existsCandidateByNationalIdentityNumber(candidate.getNationalIdentityNumber()))
            return new ErrorResult("Kimlik numarasi sisteme daha önce kaydolmus");

        if (!nationalIdValidationService.validate(candidate.getNationalIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear()).isSuccess())
            return new ErrorResult("Kullanici kimligi dogrulanamadi");

        if (!mailValidationService.validate(candidate.getEmail()).isSuccess())
            return new ErrorResult("Mail dogrulamasi basarisiz");

        candidate.setCreateDate(Long.toString(System.currentTimeMillis()));
        candidateDao.save(candidate);
        return new SuccessResult(candidate.getEmail() + " : Sisteme kaydoldu");

    }

    @Override
    public DataResult<CVWithCandidateDto> getCvById(int userId) {

        CVWithCandidateDto cv = new CVWithCandidateDto();

        cv.setCandidate(getById(userId).getData());
        cv.setEducationSet(educationService.getEducationsByCandidate_IdOrderByEntryDateDesc(userId).getData());
        cv.setJobExperienceSet(jobExperienceService.getJobExperiencesByCandidate_IdOrderByStartDateOfWorkStartDateOfWorkDesc(userId).getData());
        cv.setLanguageSet(languageService.getByUserId(userId).getData());
        cv.setGithubLink(githubLinkService.getbyUserId(userId).getData());
        cv.setSocialLinkSet(socialLinkService.getByUserId(userId).getData());
        cv.setTechnicalSkillSet(technicalSkillService.getByUserId(userId).getData());
        cv.setCoverLetter(coverLetterService.getByUSerId(userId).getData());
        cv.setImage(imageService.getByUserId(userId).getData());

        return new SuccessDataResult<>(cv);
    }

    private boolean nullControl(Candidate candidate) {
        return candidate.getFirstName() != null &&
                candidate.getLastName() != null &&
                candidate.getNationalIdentityNumber() != null &&
                candidate.getBirthYear() != null &&
                candidate.getPasswordRepeat() != null;
    }


}
