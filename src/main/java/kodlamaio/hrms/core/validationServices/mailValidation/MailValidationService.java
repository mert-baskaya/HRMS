package kodlamaio.hrms.core.validationServices.mailValidation;

import kodlamaio.hrms.core.utilities.results.Result;

public interface MailValidationService {
	Result validate(String email);
}
