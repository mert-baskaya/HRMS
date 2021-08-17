package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.cvs.ImageService;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    //https://www.baeldung.com/sprint-boot-multipart-requests
    @PostMapping(value = "/add",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result addImageToUser(@RequestParam int userId,@RequestPart(value = "file") MultipartFile file){
        return imageService.add(file,userId);
    }

}
