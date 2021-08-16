package kodlamaio.hrms.core.adapters.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Component
public class CloudManager implements CloudService{

    //Burası aşırı havada, düzgünce öğrenmek gerek

    private final Cloudinary cloudinary;

    public CloudManager() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dnsfzrpye",
                "api_key", "729281238438624",
                "api_secret", "aIn6kCNHgcaPjUNtQf8OLDVdgoQ"));
    }

    @Override
    public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        File file;
        try {
            file=convert(multipartFile);
            Map<String, String> result=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        }
        catch(IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya yuklenmedi.");
        }    }

    public DataResult<Map> delete(String id) throws IOException {
        Map result=cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return new SuccessDataResult<>(result);
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file=new File(multipartFile.getOriginalFilename());
        FileOutputStream stream=new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;

    }
}
