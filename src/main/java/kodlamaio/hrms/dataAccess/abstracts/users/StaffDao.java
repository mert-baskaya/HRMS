package kodlamaio.hrms.dataAccess.abstracts.users;

import kodlamaio.hrms.entities.concretes.users.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao extends JpaRepository<Staff, Integer> {
}
