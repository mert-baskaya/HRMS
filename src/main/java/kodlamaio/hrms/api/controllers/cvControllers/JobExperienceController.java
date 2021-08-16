package kodlamaio.hrms.api.controllers.cvControllers;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvDetails.jobExperiences.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperienceController {

    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobExperience jobExperience, int candidateId){
        return jobExperienceService.addJobExperience(jobExperience,candidateId);
    }

    @PostMapping("/getByDateDesc")
    public DataResult<List<JobExperience>> getByDateDesc(@RequestBody int candidateId){
        return jobExperienceService.getJobExperiencesByCandidate_IdOrderByStartDateOfWorkStartDateOfWorkDesc(candidateId);
    }
}
