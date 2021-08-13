package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvDetails.dtos.DepartmentWithSchoolIdDto;
import kodlamaio.hrms.entities.concretes.cvDetails.educations.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/schoolDepartments")
public class SchoolDepartmentController {

    private final SchoolDepartmentService schoolDepartmentService;

    @Autowired
    public SchoolDepartmentController(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }

    @PostMapping("/add")
    Result add(@RequestBody @Valid DepartmentWithSchoolIdDto departmentWithSchoolIdDto){
        return this.schoolDepartmentService.add(departmentWithSchoolIdDto);
    }
    @PostMapping("/getById")
    DataResult<SchoolDepartment> getById(@RequestBody int id){
        return this.schoolDepartmentService.getById(id);
    }

    @PostMapping("/getAllBySchoolId")
    DataResult<List<SchoolDepartment>> getAllBySchoolId(@RequestBody int id){
        return this.schoolDepartmentService.getAllBySchoolId(id);
    }

}
