package kodlamaio.hrms.core.validationServices.staffValidation;

import kodlamaio.hrms.business.concretes.users.EmployerManager;
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
        //Acaba bunun business ile konuşması mı yoksa kendi içinde mi yapması daha doğru bilemedim
        return employerManager.approveEmployerByEmail(email);
    }
}
