package kodlamaio.hrms.dataAccess.abstracts.cvs;

import kodlamaio.hrms.entities.concretes.cvs.languages.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
