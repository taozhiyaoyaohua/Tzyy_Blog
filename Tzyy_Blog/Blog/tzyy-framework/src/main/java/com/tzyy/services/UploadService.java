package com.tzyy.services;

import com.tzyy.tools.ResponseResultUtils;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    ResponseResultUtils upload(MultipartFile img);
}
