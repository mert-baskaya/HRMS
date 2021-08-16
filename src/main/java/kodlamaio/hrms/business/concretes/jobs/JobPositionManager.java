package kodlamaio.hrms.business.concretes.jobs;

import kodlamaio.hrms.business.abstracts.jobs.JobPositonService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.jobs.JobPositionDao;
import kodlamaio.hrms.entities.concretes.jobs.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositonService {

    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }


    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(), "Data getirildi");
    }

    @Override
    public Result addPosition(JobPosition jobPosition) {
        if(jobPositionDao.existsByTitle(jobPosition.getTitle())){
            return new ErrorResult("Bu is pozisyonu daha once kaydedilmis");
        }else{
            jobPositionDao.save(jobPosition);
            return new SuccessResult(jobPosition.getTitle() + " Kaydedildi");
        }
    }

    @Override
    public DataResult<JobPosition> getByTitle(String title) {
        if(!jobPositionDao.existsByTitle(title)) return new ErrorDataResult<>(title + " Sistemde kayıtlı değil");
        else return new SuccessDataResult<>(jobPositionDao.getByTitle(title));
    }
}
