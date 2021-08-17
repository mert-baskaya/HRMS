package kodlamaio.hrms.business.concretes.cvs;

import kodlamaio.hrms.business.abstracts.cvs.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.cvs.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.cvs.jobExperiences.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private final JobExperienceDao jobExperienceDao;
    private final CandidateDao candidateDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, CandidateDao candidateDao) {
        this.jobExperienceDao = jobExperienceDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result addJobExperience(JobExperience jobExperience, int candidateId) {
        if(candidateDao.existsById(candidateId)){
            jobExperience.setCandidate(candidateDao.getById(candidateId));
            jobExperienceDao.save(jobExperience);
            return new SuccessResult("Kaydedildi");
        }else{
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<JobExperience>> getJobExperiencesByCandidate_IdOrderByStartDateOfWorkStartDateOfWorkDesc(int candidateId) {
        return new SuccessDataResult<>(jobExperienceDao.getJobExperiencesByCandidate_IdOrderByStartDateOfWorkDesc(candidateId));
    }
}
