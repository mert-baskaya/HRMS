package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.jobs.JobPosition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

    JobPosition getByTitle(String title);

    boolean existsByTitle(String title);

}
