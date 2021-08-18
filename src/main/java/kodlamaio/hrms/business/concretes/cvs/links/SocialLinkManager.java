package kodlamaio.hrms.business.concretes.cvs.links;

import kodlamaio.hrms.business.abstracts.cvs.links.SocialLinkService;
import kodlamaio.hrms.business.abstracts.users.CandidateService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.cvs.links.SocialLinkDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.cvs.links.SocialLink;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialLinkManager implements SocialLinkService {

    private final SocialLinkDao socialLinkDao;
    private final CandidateDao candidateDao;

    public SocialLinkManager(SocialLinkDao socialLinkDao, CandidateDao candidateDao) {
        this.socialLinkDao = socialLinkDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(String url, int id) {

        if (socialLinkDao.existsByUrl(url)) return new ErrorResult("Bu URL daha önce sisteme kaydolmuş");

        if (candidateDao.existsById(id)) {
            Candidate candidate = candidateDao.getById(id);
            SocialLink socialLink = new SocialLink();
            socialLink.setUrl(url);
            socialLink.setCandidate(candidate);
            socialLinkDao.save(socialLink);
            return new SuccessResult("Başarılı");
        } else {
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<SocialLink>> getByUserId(int userId) {
        return new SuccessDataResult<>(socialLinkDao.getByCandidate_Id(userId));
    }
}
