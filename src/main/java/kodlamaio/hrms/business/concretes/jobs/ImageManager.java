package kodlamaio.hrms.business.concretes.jobs;

import kodlamaio.hrms.business.abstracts.cvs.ImageService;
import kodlamaio.hrms.business.abstracts.users.CandidateService;
import kodlamaio.hrms.core.adapters.cloudinary.CloudService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.cvs.ImageDao;
import kodlamaio.hrms.dataAccess.abstracts.users.CandidateDao;
import kodlamaio.hrms.entities.concretes.cvs.Image;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ImageManager implements ImageService {

    // Bu alan https://github.com/htcoztrk'ten alıntı yapılarak yazıldı

    private final ImageDao imageDao;
    private final CandidateDao candidateDao;
    private final CloudService cloudService;

    @Autowired
    public ImageManager(ImageDao imageDao, CandidateDao candidateDao, CloudService cloudService) {
        this.imageDao = imageDao;
        this.candidateDao = candidateDao;
        this.cloudService = cloudService;
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<>(this.imageDao.findAll(),"listelendi");
    }
    @Override
    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<>(this.imageDao.findById(id).get(),"resim:");
    }
    @Override
    public DataResult<Image> getByUserId(int id) {
        return new SuccessDataResult<>(this.imageDao.getByCandidate_Id(id));
    }
    @Override
    public Result add(MultipartFile multipartFile,int id) {
        var result=this.cloudService.upload(multipartFile);
        if(!result.isSuccess()) {
            return new ErrorResult(result.getMessage());
        }
        Candidate candidate = this.candidateDao.getById(id);
        Image image=new Image();
        image.setCandidate(candidate);
        image.setUrl(result.getData().get("url"));
        image.setPublicId(result.getData().get("public_id"));
        image.setUploadDateTime(ZonedDateTime.parse(result.getData().get("created_at")));
        this.imageDao.save(image);
        return new SuccessResult("photo added");
    }
    @Override
    public Result delete(int id) throws IOException {
        var public_id=this.imageDao.findById(id).get().getPublicId();
        var result=this.cloudService.delete(public_id);
        this.imageDao.deleteById(id);

        return new SuccessResult("deleted");
    }
}
