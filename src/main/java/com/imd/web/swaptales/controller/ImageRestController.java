package com.imd.web.swaptales.controller;

import com.imd.web.swaptales.dto.BookDTO;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageRestController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file){
        try{
            String path = imageService.uploadImage(file);
            return ResponseEntity.ok(path);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
