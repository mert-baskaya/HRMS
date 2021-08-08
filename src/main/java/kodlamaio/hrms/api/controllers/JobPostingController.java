package kodlamaio.hrms.api.controllers;

import io.swagger.annotations.Api;
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.users.EmployerDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Job Posting Api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api/jobPostings")
@Validated
public class JobPostingController {

    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingController(JobPostingService jobPostingService, EmployerDao employerDao, CityDao cityDao, JobPositionDao jobPositionDao) {
        this.jobPostingService = jobPostingService;
    }

    //@Validated aranan şehir idsi 1den büyük olmalı...

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobPostingDto dto){
        return jobPostingService.addJobPosting(dto);
    }
    @GetMapping("/getAllActive")
    public DataResult<List<JobPosting>> getAllActive(){
        return jobPostingService.getAllActive();
    }

}
