package kodlamaio.hrms.api.controllers.cvs.links;

import kodlamaio.hrms.business.abstracts.cvs.links.GithubLinkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/githubLink")
public class GithubLinkController {

    private final GithubLinkService githubLinkService;

    public GithubLinkController(GithubLinkService githubLinkService) {
        this.githubLinkService = githubLinkService;
    }
}
