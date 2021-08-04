package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    boolean existsByEmail(String email);
    boolean existsByNationalIdentityNumber(String nationalIdentityNumber);
}
