package kodlamaio.hrms.dataAccess.abstracts.user;

import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    boolean existsCandidateByNationalIdentityNumber(String nationalIdentityNumber);
}
