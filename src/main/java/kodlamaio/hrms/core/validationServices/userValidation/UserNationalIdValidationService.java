package kodlamaio.hrms.core.validationServices.userValidation;

import kodlamaio.hrms.core.utilities.results.Result;

public interface UserNationalIdValidationService {
	Result validate(String nationalId, String firstName, String lastName, String birthYear);
}
