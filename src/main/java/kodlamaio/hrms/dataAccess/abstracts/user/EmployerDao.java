package kodlamaio.hrms.dataAccess.abstracts.user;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.users.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Employer getByEmail(String email);

    boolean existsByEmail(String email);

}
