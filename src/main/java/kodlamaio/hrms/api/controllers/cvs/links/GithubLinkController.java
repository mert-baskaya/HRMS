package kodlamaio.hrms.api.controllers.cvs.links;

import kodlamaio.hrms.business.abstracts.cvs.links.GithubLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.links.GithubLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/githubLink")
public class GithubLinkController {

    private final GithubLinkService githubLinkService;

    @Autowired
    public GithubLinkController(GithubLinkService githubLinkService) {
        this.githubLinkService = githubLinkService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody String url, int userId){
        return githubLinkService.add(url, userId);
    }

    @PostMapping("/getByUserId")
    public DataResult<GithubLink> getByUserId(@RequestParam int userId){
        return githubLinkService.getbyUserId(userId);
    }
}
