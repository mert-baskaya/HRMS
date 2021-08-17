package kodlamaio.hrms.dataAccess.abstracts.cvs;

import kodlamaio.hrms.entities.concretes.cvs.skills.TechnicalSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalSkillDao extends JpaRepository<TechnicalSkill, Integer> {
}
