package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    boolean existsByEmail (String email);
    User getUserByEmail (String email);
}
