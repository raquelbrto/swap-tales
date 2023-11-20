package com.imd.web.swaptales.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.imd.web.swaptales.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private Cloudinary cloudinary;

    public String uploadImage(MultipartFile image) throws IOException {
        Path path = Files.createTempFile("temp", image.getOriginalFilename());

        File file = path.toFile();
        image.transferTo(file);

        Map uploadRequest = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "resources"));

        file.delete();

        return (String) uploadRequest.get("url");
    }

    private boolean isValidateImage(MultipartFile image){
        List<String> contentTypes = Arrays.asList("image/png", "image/jpg", "image/jpeg");

        for(int i = 0; i < contentTypes.size(); i++){
            if(image.getContentType().toLowerCase().startsWith(contentTypes.get(i))){
                return true;
            }
        }
        return false;
    }
}
