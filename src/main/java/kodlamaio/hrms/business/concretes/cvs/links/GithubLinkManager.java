package kodlamaio.hrms.business.concretes.cvs.links;

import kodlamaio.hrms.business.abstracts.cvs.links.GithubLinkService;
import kodlamaio.hrms.business.abstracts.users.CandidateService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvs.links.GithubLinkDao;
import kodlamaio.hrms.entities.concretes.cvs.links.GithubLink;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.stereotype.Service;

@Service
public class GithubLinkManager implements GithubLinkService {

    private final GithubLinkDao githubLinkDao;
    private final CandidateService candidateService;

    public GithubLinkManager(GithubLinkDao githubLinkDao, CandidateService candidateService) {
        this.githubLinkDao = githubLinkDao;
        this.candidateService = candidateService;
    }

    @Override
    public Result add(String url, int candidateId) {

        if(githubLinkDao.existsByUrl(url)) return new ErrorResult("Bu URL daha önce sisteme kaydolmuş");

        //Bu tarz yapılarda try-cath olmayınca kaşıntı basıyor
        if(candidateService.getById(candidateId).isSuccess()){
            Candidate candidate = candidateService.getById(candidateId).getData();
            GithubLink githubLink = new GithubLink();
            githubLink.setUrl(url);
            githubLink.setCandidate(candidate);
            githubLinkDao.save(githubLink);
            return new SuccessResult("Başarılı");
        }
        return new ErrorResult("Github linki eklenemedi");
    }
}
