package kodlamaio.hrms.core.validationServices.staffValidation;

import kodlamaio.hrms.core.utilities.results.Result;

public interface StaffValidationService {
    Result activateEmployer(String email);
}
