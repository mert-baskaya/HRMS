package kodlamaio.hrms.core.business;

import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entites.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService{

    private final UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<User> getById(int id) {
        if(userDao.existsById(id)){
        return new SuccessDataResult<>(userDao.getById(id));
        }else{
            return new ErrorDataResult<>("Kullanıcı bulunamadı");
        }
    }
}
