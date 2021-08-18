package kodlamaio.hrms.api.controllers.cvs.links;

import kodlamaio.hrms.business.abstracts.cvs.links.GithubLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.links.GithubLink;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/githubLink")
public class GithubLinkController {

    private final GithubLinkService githubLinkService;

    public GithubLinkController(GithubLinkService githubLinkService) {
        this.githubLinkService = githubLinkService;
    }

    @PostMapping("/add")
    public Result add(String url, int userId){
        return githubLinkService.add(url, userId);
    }

    @PostMapping("/getByUserId")
    public DataResult<GithubLink> getByUserId(int userId){
        return githubLinkService.getbyUserId(userId);
    }
}
