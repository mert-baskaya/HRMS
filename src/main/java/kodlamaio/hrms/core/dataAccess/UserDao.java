package kodlamaio.hrms.core.dataAccess;

import kodlamaio.hrms.core.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    boolean existsUserByEmail(String email);

    boolean existsByEmail(String email);
}
