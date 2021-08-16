package kodlamaio.hrms.business.concretes.jobs;

import kodlamaio.hrms.business.abstracts.cvs.ImageService;
import kodlamaio.hrms.core.adapters.cloudinary.CloudService;
import kodlamaio.hrms.core.business.UserService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.cvs.ImageDao;
import kodlamaio.hrms.entities.concretes.cvs.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImageManager implements ImageService {

    // Bu alan https://github.com/htcoztrk'ten alıntı yapılarak yazıldı

    private final ImageDao imageDao;
    private final UserService userService; //todo gerekli restructuring işlemleri
    private final CloudService cloudService;

    @Autowired
    public ImageManager(ImageDao imageDao, UserService userService, CloudService cloudService) {
        this.imageDao = imageDao;
        this.userService = userService;
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
    public DataResult<List<Image>> getByUserId(int id) {
        return new SuccessDataResult<>(this.imageDao.getByUser_Id(id));
    }
    @Override
    public Result add(MultipartFile multipartFile,int id) {
        var result=this.cloudService.upload(multipartFile);
        if(!result.isSuccess()) {
            return new ErrorResult(result.getMessage());
        }
        var user=this.userService.getById(id).getData();
        Image image=new Image();
        image.setUser(user);
        image.setUrl(result.getData().get("url"));
        image.setPublicId(result.getData().get("public_id"));
        image.setUploadDateTime(LocalDateTime.parse(result.getData().get("created_at")));
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
