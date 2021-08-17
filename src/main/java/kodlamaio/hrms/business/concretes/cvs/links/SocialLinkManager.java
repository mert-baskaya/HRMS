package kodlamaio.hrms.business.concretes.cvs.links;

import kodlamaio.hrms.business.abstracts.cvs.links.SocialLinkService;
import kodlamaio.hrms.business.abstracts.users.CandidateService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvs.links.SocialLinkDao;
import kodlamaio.hrms.entities.concretes.cvs.links.SocialLink;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.stereotype.Service;

@Service
public class SocialLinkManager implements SocialLinkService {

    private final SocialLinkDao socialLinkDao;
    private final CandidateService candidateService;

    public SocialLinkManager(SocialLinkDao socialLinkDao, CandidateService candidateService) {
        this.socialLinkDao = socialLinkDao;
        this.candidateService = candidateService;
    }

    @Override
    public Result add(String url, int id) {

        if(socialLinkDao.existsByUrl(url)) return new ErrorResult("Bu URL daha önce sisteme kaydolmuş");

        if(candidateService.getById(id).isSuccess()){
            Candidate candidate = candidateService.getById(id).getData();
            SocialLink socialLink = new SocialLink();
            socialLink.setUrl(url);
            socialLink.setCandidate(candidate);
            socialLinkDao.save(socialLink);
            return new SuccessResult("Başarılı");
        }

        return new ErrorResult("Sosyal link eklenemedi");
    }
}
