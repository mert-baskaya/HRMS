package kodlamaio.hrms.business.concretes.cvs.links;

import kodlamaio.hrms.business.abstracts.cvs.links.GithubLinkService;
import kodlamaio.hrms.business.abstracts.users.CandidateService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.cvs.links.GithubLinkDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.cvs.links.GithubLink;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.stereotype.Service;

@Service
public class GithubLinkManager implements GithubLinkService {

    //Burada CandidateService çağrısı yapılıp CandidateManager'da da GithubLinkService çağrısı yapıldığında sonsuz döngü yapıyor
    //Sanırım mecburen daolarla erişim yapmak durumunda kalacağım
    private final GithubLinkDao githubLinkDao;
    //private final CandidateService candidateService;
    private final CandidateDao candidateDao;

    public GithubLinkManager(GithubLinkDao githubLinkDao, CandidateDao candidateDao) {
        this.githubLinkDao = githubLinkDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(String url, int candidateId) {

        if(githubLinkDao.existsByUrl(url)) return new ErrorResult("Bu URL daha önce sisteme kaydolmuş");

        //Bu tarz yapılarda try-cath olmayınca kaşıntı basıyor
        if(candidateDao.existsById(candidateId)){
            Candidate candidate = candidateDao.getById(candidateId);
            GithubLink githubLink = new GithubLink();
            githubLink.setUrl(url);
            githubLink.setCandidate(candidate);
            githubLinkDao.save(githubLink);
            return new SuccessResult("Başarılı");
        }
        return new ErrorResult("Github linki eklenemedi");
    }

    @Override
    public DataResult<GithubLink> getbyUserId(int userId) {
        return new SuccessDataResult<>(githubLinkDao.getByCandidate_Id(userId));
    }
}
