package kodlamaio.hrms.dataAccess.abstracts.cvs.links;

import kodlamaio.hrms.entities.concretes.cvs.links.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer> {

    boolean existsByUrl(String url);

    List<SocialLink> getByCandidate_Id(int id);

}
