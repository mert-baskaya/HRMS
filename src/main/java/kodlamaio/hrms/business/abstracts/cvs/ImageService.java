package kodlamaio.hrms.business.abstracts.cvs;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    DataResult<List<Image>> getAll();
    DataResult<Image> getById(int id);
    DataResult<List<Image>> getByUserId(int id);

    Result add(MultipartFile multipartFile , int id);
    Result delete(int id) throws IOException;

}
