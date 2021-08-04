package kodlamaio.hrms.core.validationServices.mailValidation;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;

@Service
public class PsudoMailValidation implements MailValidationService{

	@Override
	public Result validate(String email) {
		return new Result(true, email + ": Mail dogrulandi");
	}

}
