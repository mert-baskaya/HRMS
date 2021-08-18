package kodlamaio.hrms.business.abstracts.cvs.links;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.links.SocialLink;

import java.util.List;

public interface SocialLinkService {

    Result add(String url, int id);

    DataResult<List<SocialLink>> getByUserId(int userId);
}
