package kodlamaio.hrms.business.abstracts.cvs;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.skills.TechnicalSkill;

import java.util.List;

public interface TechnicalSkillService {
    Result add(String skillName, int id);

    DataResult<List<TechnicalSkill>> getByUserId(int userId);
}
