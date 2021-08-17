package kodlamaio.hrms.dataAccess.abstracts.cvs.links;

import kodlamaio.hrms.entities.concretes.cvs.links.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer> {

    boolean existsByUrl(String url);

}
