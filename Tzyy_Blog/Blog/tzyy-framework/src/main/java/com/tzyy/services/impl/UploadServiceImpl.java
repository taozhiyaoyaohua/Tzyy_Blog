package com.tzyy.services.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.tzyy.enums.AppHttpCodeEnum;
import com.tzyy.exception.SystemException;
import com.tzyy.pojo.LoginUser;
import com.tzyy.pojo.User;
import com.tzyy.services.UploadService;
import com.tzyy.tools.PathUtils;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.tools.SecurityUtils;
import lombok.Data;
import org.ehcache.core.spi.service.ServiceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service("uploadService")
@Data
public class UploadServiceImpl implements UploadService {
    @Value("${oss.accessKeyId}")
    private String accessKeyId;
    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${oss.bucket}")
    private String bucket;
    @Value("${oss.endpoint}")
    private String endpoint;
    @Override
    public ResponseResultUtils upload(MultipartFile img) {
        String originalFilename = img.getOriginalFilename();
        //对原始文件名进行判断
        if(!originalFilename.endsWith(".png")&&!originalFilename.endsWith(".jpg")){
            throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
        }
        String filePath = PathUtils.generateFilePath(originalFilename);
        String url = uploadOSS(img,filePath);
        return ResponseResultUtils.okResult(url);
    }
    private String uploadOSS(MultipartFile img,String filePath) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String key = filePath;
        try {
            if (ossClient.doesBucketExist(bucket)) {
                System.out.println("您已经创建Bucket：" + bucket + "。");
            } else {
                System.out.println("您的Bucket不存在，创建Bucket：" + bucket + "。");
                ossClient.createBucket(bucket);
            }
            InputStream is = img.getInputStream();
            PutObjectResult putObjectResult = ossClient.putObject(bucket, key, is);
            String url = "https://tzyyblog.oss-cn-hangzhou.aliyuncs.com/"+key;
            return url;
        } catch (OSSException oe) {
            oe.printStackTrace();
        } catch (ClientException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return null;
    }
}
