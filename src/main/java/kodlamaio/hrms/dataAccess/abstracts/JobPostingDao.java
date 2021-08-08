package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
    List<JobPosting> getAllByIsActiveIsTrue();
    List<JobPosting> getAllByIsActiveIsTrueOrderByReleaseDate();
    List<JobPosting> getAllByEmployerCompanyName(String companyName);
}
