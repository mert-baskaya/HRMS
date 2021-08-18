package kodlamaio.hrms.api.controllers.cvs;

import kodlamaio.hrms.business.abstracts.cvs.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coverLetter")
public class CoverLetterController {

    private final CoverLetterService coverLetterService;

    @Autowired
    public CoverLetterController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("add")
    public Result addCoverLetter(@RequestParam String summary,@RequestParam int userId){
        return coverLetterService.add(summary, userId);
    }

    @PostMapping("/getById")
    public DataResult<CoverLetter> getById(int userId){
        return coverLetterService.getByUSerId(userId);
    }
}
