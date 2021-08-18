package kodlamaio.hrms.dataAccess.abstracts.users;

import kodlamaio.hrms.entities.concretes.cvs.Image;
import kodlamaio.hrms.entities.concretes.cvs.dtos.CVWithCandidateDto;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    boolean existsCandidateByNationalIdentityNumber(String nationalIdentityNumber);

    @Query("update Candidate c set c.image = ?1 where c.id = ?2")
    void updateImageById(int userId, Image image);

    // this query is an abomination to all software developers
    /*
    @Query(value = "select new kodlamaio.hrms.entities.concretes.cvs.dtos.CVWithCandidateDto" +
            "(c, c.educations, c.jobExperiences, c.languages, c.image, c.githubLink, c.socialLinks, c.technicalSkills, c.coverLetter) " +
            "from Candidate as c " +
            "inner join Education as edu on c.id = edu.candidate.id " +
            "inner join JobExperience as job on c.id = job.candidate.id " +
            "inner join Language as lang on c.id = lang.candidate.id " +
            "inner join Image as img on c.id = img.candidate.id " +
            "inner join GithubLink as git on c.id = git.candidate.id " +
            "inner join SocialLink as social on c.id = social.candidate.id " +
            "inner join TechnicalSkill as tSkill on c.id = tSkill.candidate.id " +
            "inner join CoverLetter as letter on c.id = letter.candidate.id " +
            "where c.id = ?1")
    CVWithCandidateDto getCV(int userId);
     */
}
