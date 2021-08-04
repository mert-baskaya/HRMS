package kodlamaio.hrms.core.validationServices.userValidation;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class PsudoMernisValidation implements UserNationalIdValidationService {

	@Override
	public Result validate(String nationalId, String firstName, String lastName, String birthYear) {
		
		return new SuccessResult("Kimlik numarasi dogrulandi: " + nationalId);

		/*
		if (NationalIdVerification.isTCKNCorrect(nationalId)) {
			return new SuccessResult("Kimlik numarasi dogrulandi");
		} else {
			return new ErrorResult("Kimlik numarasi dogrulanamadi");
		}
		*/
	}

}
