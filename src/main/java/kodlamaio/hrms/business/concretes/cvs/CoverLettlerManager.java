package kodlamaio.hrms.business.concretes.cvs;

import kodlamaio.hrms.business.abstracts.cvs.CoverLetterService;
import kodlamaio.hrms.business.abstracts.users.CandidateService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvs.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.stereotype.Service;

@Service
public class CoverLettlerManager implements CoverLetterService {

    private final CoverLetterDao coverLetterDao;
    private final CandidateService candidateService;

    //TODO Önemli!
    // Bütün business sınıflarınındaki dao erişimlerini kaldırıp service erişimine çevir.
    //Projenin tasarım modelinin bu şekilde olması gerektiğini düşünüyorum,
    // bir iş sınıfının başka bir iş sınıfının dao'suna müdahele edebiliyor olması doğru değil gibi geliyor

    public CoverLettlerManager(CoverLetterDao coverLetterDao, CandidateService candidateService) {
        this.coverLetterDao = coverLetterDao;
        this.candidateService = candidateService;
    }

    @Override
    public Result add(String summary, int candidateId) {
        // veritabanına 2 çağrı yapılıyor, yüksek veri hacimli projelerde sunucuya fazla yük bindirebilir
        // fakat dao'larla yapılan operasyonlarla da 2 çağrı yapılıyor sanırım. araştırmak gerekli
        Candidate candidate = candidateService.getById(candidateId).getData();
        if(!candidateService.getById(candidateId).isSuccess()) return new ErrorResult();
        CoverLetter coverLetter = new CoverLetter();
        coverLetter.setSummary(summary);
        coverLetter.setCandidate(candidate);
        coverLetterDao.save(coverLetter);
        return new SuccessResult("Ön yazı eklendi");
    }
}
