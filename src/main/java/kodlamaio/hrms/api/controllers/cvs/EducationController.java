package kodlamaio.hrms.api.controllers.cvs;

import kodlamaio.hrms.business.abstracts.cvs.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.educations.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Education education, int candidateId){
        return educationService.addEducation(education, candidateId);
    }

    @PostMapping("/getByDateDesc")
    public DataResult<List<Education>> getByDateDesc(@RequestBody int candidateId){
        return educationService.getEducationsByCandidate_IdOrderByEntryDateDesc(candidateId);
    }
}
