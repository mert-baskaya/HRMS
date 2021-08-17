package kodlamaio.hrms.dataAccess.abstracts.cvs.links;

import kodlamaio.hrms.entities.concretes.cvs.links.GithubLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GithubLinkDao extends JpaRepository<GithubLink, Integer> {

    boolean existsByUrl(String url);

}
