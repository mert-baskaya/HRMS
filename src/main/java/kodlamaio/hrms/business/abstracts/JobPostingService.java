package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;

import java.util.List;

public interface JobPostingService {
    Result addJobPosting(JobPostingDto dto);

    DataResult<List<JobPosting>> getAllActive();
}
