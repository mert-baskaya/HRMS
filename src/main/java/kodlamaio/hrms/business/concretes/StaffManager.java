package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.users.StaffDao;
import kodlamaio.hrms.entities.concretes.users.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffManager implements StaffService {

    private final StaffDao staffDao;

    private final UserDao userDao;

    @Autowired
    public StaffManager(StaffDao staffDao, UserDao userDao) {
        this.staffDao = staffDao;
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<Staff>> getAll() {
        return new SuccessDataResult<>(this.staffDao.findAll(), "Data getirildi");
    }

    @Override
    public Result add(Staff staff) {

        if(userDao.existsUserByEmail(staff.getEmail())) return new ErrorResult("Email sisteme daha önce kaydolmuş");

        this.staffDao.save(staff);
        return new SuccessResult("Personel eklendi: " + staff.getEmail());
    }
}
