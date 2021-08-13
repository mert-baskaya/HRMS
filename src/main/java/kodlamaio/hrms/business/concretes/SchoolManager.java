package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.cvDetails.educations.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private final SchoolDao schoolDao;

    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }


    @Override
    public Result add(School school) {
        schoolDao.save(school);
        return new SuccessResult();
    }

    @Override
    public DataResult<School> getByName(String schoolName) {
        if(!schoolDao.existsBySchoolName(schoolName)) return new ErrorDataResult<>("Bu isme ait okul bulunamadı");
        return new SuccessDataResult<>(schoolDao.getBySchoolName(schoolName));
    }

    @Override
    public DataResult<School> getById(int id) {
        if(!schoolDao.existsById(id)) return new ErrorDataResult<>("Bu id'ye ait okul bulunamadı");
        return new SuccessDataResult<>(schoolDao.getById(id));
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(schoolDao.findAll());
    }
}
