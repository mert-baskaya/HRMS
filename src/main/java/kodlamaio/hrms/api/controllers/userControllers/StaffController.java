package kodlamaio.hrms.api.controllers.userControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.validationServices.staffValidation.StaffValidationService;
import kodlamaio.hrms.entities.concretes.users.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Staff Controller Api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    private final StaffValidationService validationService;

    @Autowired
    public StaffController(StaffService staffService, StaffValidationService validationService) {
        this.staffService = staffService;
        this.validationService = validationService;
    }

    @GetMapping("/getAll")
    @ApiOperation("Gets all the Staff")
    public DataResult<List<Staff>> getAll(){
        return this.staffService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Staff staff){
        return this.staffService.add(staff);
    }

    @PostMapping("acivateEmployerByMail")
    public Result activateEmployerByMail(@RequestBody String email){
        return validationService.activateEmployer(email);
    }

}
