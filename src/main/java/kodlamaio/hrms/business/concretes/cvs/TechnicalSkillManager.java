package kodlamaio.hrms.business.concretes.cvs;

import kodlamaio.hrms.business.abstracts.cvs.TechnicalSkillService;
import kodlamaio.hrms.business.abstracts.users.CandidateService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvs.TechnicalSkillDao;
import kodlamaio.hrms.entities.concretes.cvs.skills.TechnicalSkill;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.stereotype.Service;

@Service
public class TechnicalSkillManager implements TechnicalSkillService {

    private final TechnicalSkillDao technicalSkillDao;
    private final CandidateService candidateService;

    public TechnicalSkillManager(TechnicalSkillDao technicalSkillDao, CandidateService candidateService) {
        this.technicalSkillDao = technicalSkillDao;
        this.candidateService = candidateService;
    }

    @Override
    public Result add(String skillName, int id) {

        //TODO Proje elden geçirilmeli!!!

        //Bu yapı doğru değil, bana controller'dan bir obje gelmesi gerekiyor.
        //Şu anda çalışır fakat prensip olarak ekleme gerektiğinde
        // burayı modifiye etmem gerekeceğinden doğru kullanımı bu değil

        if(candidateService.getById(id).isSuccess()){
            Candidate candidate = candidateService.getById(id).getData();
            TechnicalSkill technicalSkill = new TechnicalSkill();
            technicalSkill.setSkillName(skillName);
            technicalSkill.setCandidate(candidate);
            technicalSkillDao.save(technicalSkill);
            return new SuccessResult("Başarılı");
        }

        return new ErrorResult("Teknik yetenek eklenemedi");
    }
}
