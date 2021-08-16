package kodlamaio.hrms.business.abstracts.jobs;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.jobs.JobPosition;

import java.util.List;

public interface JobPositonService {
    DataResult<List<JobPosition>> getAll();
    Result addPosition(JobPosition jobPosition);
    DataResult<JobPosition> getByTitle(String title);
}
