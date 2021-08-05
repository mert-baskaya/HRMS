package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<Staff, Integer> {
}
