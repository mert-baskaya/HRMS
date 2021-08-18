package kodlamaio.hrms.business.abstracts.users;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.Image;
import kodlamaio.hrms.entities.concretes.cvs.dtos.CVWithCandidateDto;
import kodlamaio.hrms.entities.concretes.cvs.educations.Education;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CandidateService {
    DataResult<Candidate> getById(int id);
    DataResult<List<Candidate>> getAll();

    Result add(Candidate candidate);
    DataResult<CVWithCandidateDto> getCvById(int userId);

}
