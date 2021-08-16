package kodlamaio.hrms.core.business;

import kodlamaio.hrms.core.entites.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

public interface UserService {
    DataResult<User> getById(int id);
}
