package kodlamaio.hrms.dataAccess.abstracts.cvs;

import kodlamaio.hrms.entities.concretes.cvs.languages.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language, Integer> {

    List<Language> getByCandidate_Id(int id);

}
