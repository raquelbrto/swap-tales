package com.imd.web.swaptales.service;

import com.imd.web.swaptales.util.exception.BusinessRuleException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImage(MultipartFile image) throws IOException;
}
