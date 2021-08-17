package kodlamaio.hrms.business.abstracts.cvs.links;

import kodlamaio.hrms.core.utilities.results.Result;

public interface GithubLinkService {
    Result add(String url, int candidateId);
}
