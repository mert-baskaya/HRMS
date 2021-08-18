package kodlamaio.hrms.entities.concretes.cvs.dtos;

import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;
import kodlamaio.hrms.entities.concretes.cvs.Image;
import kodlamaio.hrms.entities.concretes.cvs.educations.Education;
import kodlamaio.hrms.entities.concretes.cvs.jobExperiences.JobExperience;
import kodlamaio.hrms.entities.concretes.cvs.languages.Language;
import kodlamaio.hrms.entities.concretes.cvs.links.GithubLink;
import kodlamaio.hrms.entities.concretes.cvs.links.SocialLink;
import kodlamaio.hrms.entities.concretes.cvs.skills.TechnicalSkill;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CVWithCandidateDto {

    private Candidate candidate;

    private List<Education> educationSet;

    private List<JobExperience> jobExperienceSet;

    private List<Language> languageSet;

    private Image image;

    private GithubLink githubLink;

    private List<SocialLink> socialLinkSet;

    private List<TechnicalSkill> technicalSkillSet;

    private CoverLetter coverLetter;

}
