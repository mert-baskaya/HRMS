package kodlamaio.hrms.api.controllers;

import io.swagger.annotations.Api;
import kodlamaio.hrms.business.abstracts.JobPositonService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Job Position Api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api/jobPositons")
public class JobPositionController {

    private final JobPositonService jobPositonService;

    @Autowired
    public JobPositionController(JobPositonService jobPositonService) {
        this.jobPositonService = jobPositonService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositonService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
        return this.jobPositonService.addPosition(jobPosition);
    }

}
