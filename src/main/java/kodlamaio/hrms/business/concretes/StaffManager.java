package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.StaffDao;
import kodlamaio.hrms.entities.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffManager implements StaffService {

    private final StaffDao staffDao;

    @Autowired
    public StaffManager(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public DataResult<List<Staff>> getAll() {
        return new SuccessDataResult<>(this.staffDao.findAll(), "Data getirildi");
    }

    @Override
    public Result add(Staff staff) {
        this.staffDao.saveAndFlush(staff);
        return new SuccessResult("Personel eklendi: " + staff.getUser().getEmail());
    }
}
