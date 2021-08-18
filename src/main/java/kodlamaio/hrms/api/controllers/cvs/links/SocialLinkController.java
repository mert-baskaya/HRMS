package kodlamaio.hrms.api.controllers.cvs.links;

import kodlamaio.hrms.business.abstracts.cvs.links.SocialLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.links.SocialLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/socialLinkController")
public class SocialLinkController {

    private final SocialLinkService socialLinkService;

    @Autowired
    public SocialLinkController(SocialLinkService socialLinkService) {
        this.socialLinkService = socialLinkService;
    }

    @PostMapping("/add")
    public Result add(String url, int userId){
        return socialLinkService.add(url, userId);
    }

    @PostMapping("/getByUserId")
    public DataResult<List<SocialLink>> getByUserId(int userId){
        return socialLinkService.getByUserId(userId);
    }

}
