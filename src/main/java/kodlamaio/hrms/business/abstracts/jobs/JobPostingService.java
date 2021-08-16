package kodlamaio.hrms.business.abstracts.jobs;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobPositionDto;

import java.util.List;

public interface JobPostingService {

    Result addJobPosting(JobPostingDto dto);

    Result deactivatePosting(int jobPostingId);

    DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllActive();

    DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllByDeadline();

    DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllByEmployer(int employerId);

    DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllCustom();

    DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllByCompanyName(String companyName, boolean isActive);

}
