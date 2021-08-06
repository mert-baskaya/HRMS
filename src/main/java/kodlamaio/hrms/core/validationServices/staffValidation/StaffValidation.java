package kodlamaio.hrms.core.validationServices.staffValidation;

import kodlamaio.hrms.business.concretes.EmployerManager;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public class StaffValidation implements StaffValidationService{

    private final EmployerManager employerManager;

    public StaffValidation(EmployerManager employerManager) {
        this.employerManager = employerManager;
    }

    @Override
    public Result activateEmployer(String email) {
        return employerManager.approveEmployerByEmail(email);
    }
}
