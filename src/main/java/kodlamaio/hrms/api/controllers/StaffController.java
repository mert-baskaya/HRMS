package kodlamaio.hrms.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Staff Controller Api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/getAll")
    @ApiOperation("Gets all the Staff")
    public DataResult<List<Staff>> getAll(){
        return this.staffService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Staff staff){
        return this.staffService.add(staff);
    }
}
