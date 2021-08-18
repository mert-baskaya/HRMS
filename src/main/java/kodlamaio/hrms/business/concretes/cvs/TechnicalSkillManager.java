package kodlamaio.hrms.business.concretes.cvs;

import kodlamaio.hrms.business.abstracts.cvs.TechnicalSkillService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.cvs.TechnicalSkillDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.cvs.skills.TechnicalSkill;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalSkillManager implements TechnicalSkillService {

    private final TechnicalSkillDao technicalSkillDao;
    private final CandidateDao candidateDao;

    public TechnicalSkillManager(TechnicalSkillDao technicalSkillDao, CandidateDao candidateDao) {
        this.technicalSkillDao = technicalSkillDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(String skillName, int id) {

        //TODO Proje elden geçirilmeli!!!

        //Bu yapı doğru değil, bana controller'dan bir obje gelmesi gerekiyor.
        //Şu anda çalışır fakat prensip olarak ekleme gerektiğinde
        // burayı modifiye etmem gerekeceğinden doğru kullanımı bu değil

        if(candidateDao.existsById(id)){
            Candidate candidate = candidateDao.getById(id);
            TechnicalSkill technicalSkill = new TechnicalSkill();
            technicalSkill.setSkillName(skillName);
            technicalSkill.setCandidate(candidate);
            technicalSkillDao.save(technicalSkill);
            return new SuccessResult("Başarılı");
        }else{
        return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<TechnicalSkill>> getByUserId(int userId) {
        return new SuccessDataResult<>(technicalSkillDao.getByCandidate_Id(userId));
    }
}
