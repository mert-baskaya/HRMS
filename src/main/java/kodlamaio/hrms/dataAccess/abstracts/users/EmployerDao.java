package kodlamaio.hrms.dataAccess.abstracts.users;

import kodlamaio.hrms.entities.concretes.users.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Employer getByEmail(String email);

    boolean existsByEmail(String email);

    Employer getByCompanyName(String companyName);

    boolean existsByCompanyName(String companyName);
}
