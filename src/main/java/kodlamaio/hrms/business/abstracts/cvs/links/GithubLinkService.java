package kodlamaio.hrms.business.abstracts.cvs.links;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.links.GithubLink;

public interface GithubLinkService {
    Result add(String url, int candidateId);

    DataResult<GithubLink> getbyUserId(int userId);
}
