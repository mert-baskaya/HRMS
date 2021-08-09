package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingListingDto;

import java.util.List;

public interface JobPostingService {

    Result addJobPosting(JobPostingDto dto);

    Result deactivatePosting(int jobPostingId);

    DataResult<List<JobPostingListingDto>> getAllActive();

    DataResult<List<JobPostingListingDto>> getAllByDeadline();

    DataResult<List<JobPostingListingDto>> getAllByEmployer(int employerId);
}
