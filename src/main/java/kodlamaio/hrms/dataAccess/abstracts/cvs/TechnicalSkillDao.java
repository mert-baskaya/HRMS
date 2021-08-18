package kodlamaio.hrms.dataAccess.abstracts.cvs;

import kodlamaio.hrms.entities.concretes.cvs.skills.TechnicalSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnicalSkillDao extends JpaRepository<TechnicalSkill, Integer> {

    List<TechnicalSkill> getByCandidate_Id(int id);

}
