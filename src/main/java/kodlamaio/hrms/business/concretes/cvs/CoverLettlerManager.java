package kodlamaio.hrms.business.concretes.cvs;

import kodlamaio.hrms.business.abstracts.cvs.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.cvs.CoverLetterDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.stereotype.Service;

@Service
public class CoverLettlerManager implements CoverLetterService {

    private final CoverLetterDao coverLetterDao;
    private final CandidateDao candidateDao;

    // Önemli!
    // Bütün business sınıflarınındaki dao erişimlerini kaldırıp service erişimine çevir(me).
    // Projenin tasarım modelinin bu şekilde olması gerektiğini düşünüyorum,
    // bir iş sınıfının başka bir iş sınıfının dao'suna müdahele edebiliyor olması doğru değil gibi geliyor
    //
    // "The dependencies of some of the beans in the application context form a cycle"
    // Kulağa her ne kadar mantıklı gelse de CV verilerini çekmek için CandidateManager'ın içinden tüm veri sınıflarına
    // erişim managerlar ile yapılıyor, o managerlar da CandidateService'i çekmek istediğinde uygulama patlıyor

    public CoverLettlerManager(CoverLetterDao coverLetterDao, CandidateDao candidateDao) {
        this.coverLetterDao = coverLetterDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(String summary, int candidateId) {
        // veritabanına 2 çağrı yapılıyor, yüksek veri hacimli projelerde sunucuya fazla yük bindirebilir
        // fakat dao'larla yapılan operasyonlarla da 2 çağrı yapılıyor sanırım. araştırmak gerekli
        Candidate candidate = candidateDao.getById(candidateId);
        if (candidateDao.existsById(candidateId)) {
            CoverLetter coverLetter = new CoverLetter();
            coverLetter.setSummary(summary);
            coverLetter.setCandidate(candidate);
            coverLetterDao.save(coverLetter);
            return new SuccessResult("Ön yazı eklendi");
        }
        return new ErrorResult("Kullanıcı bulunamadı");
    }

    @Override
    public DataResult<CoverLetter> getByUSerId(int userId) {
        return new SuccessDataResult<>(coverLetterDao.getByCandidate_Id(userId));
    }
}
