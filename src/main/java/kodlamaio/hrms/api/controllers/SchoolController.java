package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvDetails.School;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getAll")
    DataResult<List<School>> getAll(){
        return schoolService.getAll();
    }

    @PostMapping("/getByName")
    DataResult<School> getByName(@RequestBody String schoolName){
        return schoolService.getByName(schoolName);
    }

    @PostMapping("/getById")
    DataResult<School> getById(@RequestBody int id){
        return schoolService.getById(id);
    }

    @PostMapping("/add")
    Result add(@Valid @RequestBody School school){
        return schoolService.add(school);
    }

}
