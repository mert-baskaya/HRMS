package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobPositionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
    List<JobPosting> getAllByIsActiveIsTrue();
    List<JobPosting> getAllByIsActiveIsTrueOrderByApplicationDeadline();
    List<JobPosting> getAllByEmployer_Id(int employerId);

    //@Query(value = "select new kodlamaio.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobPositionDto(jp.id,jp.employer.companyName,jp.jobPosition.title,jp.openPositions,jp.releaseDate,jp.applicationDeadline) from JobPosting as jp where jp.isActive = ?1 order by jp.applicationDeadline")
    //List<JobPostingWithEmployerAndJobPositionDto> getAllByActiveStatusAndOrderByActivationDeadline(boolean isActive);

    @Query(value = "select new kodlamaio.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobPositionDto(jp.id,jp.employer.companyName,jp.jobPosition.title,jp.openPositions,jp.releaseDate,jp.applicationDeadline) from JobPosting as jp where jp.isActive = ?1")
    List<JobPostingWithEmployerAndJobPositionDto> getAllByActiveStatus(boolean isActive);

    @Query(value = "select new kodlamaio.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobPositionDto(jp.id,jp.employer.companyName,jp.jobPosition.title,jp.openPositions,jp.releaseDate,jp.applicationDeadline) from JobPosting as jp where jp.employer.companyName = ?1 and jp.isActive = ?2")
    List<JobPostingWithEmployerAndJobPositionDto> getAllByCompanyName(String companyName, boolean isActive);
}
