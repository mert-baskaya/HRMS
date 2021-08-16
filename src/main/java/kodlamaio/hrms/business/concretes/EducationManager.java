package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.cvDetails.educations.Education;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;
    private final CandidateDao candidateDao;

    public EducationManager(EducationDao educationDao, CandidateDao candidateDao) {
        this.educationDao = educationDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result addEducation(Education education, int candidateId){
        //TODO tarih kontrolleri (iş tecrübelerinde de aynı detay var)
        if(candidateDao.existsById(candidateId)){
            education.setCandidate(candidateDao.getById(candidateId));
            educationDao.save(education);
            return new SuccessResult("Kaydedildi");
        }else{
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<Education>> getEducationsByCandidate_IdOrderByEntryDateDesc(int candidateId){
        return new SuccessDataResult<>(educationDao.getEducationsByCandidate_IdOrderByEntryDateDesc(candidateId));
    }
}
