package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import kodlamaio.hrms.entities.concretes.cvDetails.dtos.DepartmentWithSchoolIdDto;
import kodlamaio.hrms.entities.concretes.cvDetails.educations.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {

    private final SchoolDepartmentDao schoolDepartmentDao;
    private final SchoolDao schoolDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao, SchoolDao schoolDao) {
        this.schoolDepartmentDao = schoolDepartmentDao;
        this.schoolDao = schoolDao;
    }

    @Override
    public Result add(DepartmentWithSchoolIdDto departmentWithSchoolIdDto) {

        if(!schoolDao.existsById(departmentWithSchoolIdDto.getSchoolId())) return new ErrorResult("Okul bulunamadı");

        SchoolDepartment schoolDepartment = new SchoolDepartment();
        schoolDepartment.setDepartmentName(departmentWithSchoolIdDto.getDepartmentName());
        schoolDepartment.setSchool(schoolDao.getById(departmentWithSchoolIdDto.getSchoolId()));
        schoolDepartmentDao.save(schoolDepartment);
        return new SuccessResult("Bölüm eklendi: " + schoolDepartment.getDepartmentName());
    }

    @Override
    public DataResult<SchoolDepartment> getById(int id) {
        System.out.println(schoolDepartmentDao.getSchoolDepartmentsBySchool_Id(id));
        return new SuccessDataResult<>(schoolDepartmentDao.getById(id));
    }

    @Override
    public DataResult<List<SchoolDepartment>> getAllBySchoolId(int schoolId) {
        return new SuccessDataResult<>(schoolDepartmentDao.getSchoolDepartmentsBySchool_Id(schoolId));
    }
}
