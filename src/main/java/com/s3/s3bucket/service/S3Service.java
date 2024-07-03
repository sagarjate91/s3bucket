package com.s3.s3bucket.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Service
@AllArgsConstructor
public class S3Service {

    private AmazonS3 amazonS3;
    private final String BUCKET_NAME="sagarjate";

    public String upload(MultipartFile file){
        File fileObj=convertToFile(file);
        amazonS3.putObject(new PutObjectRequest(BUCKET_NAME,file.getOriginalFilename(),fileObj));
        fileObj.delete();
        return "File uploaded:"+file.getOriginalFilename();
    }

    private File convertToFile(MultipartFile file) {
        File fileObj=new File(file.getOriginalFilename());
        try{
            FileOutputStream fos=new FileOutputStream(fileObj);
            fos.write(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileObj;
    }

    public byte[] download(String fileName){
        try{
            return IOUtils.toByteArray(amazonS3.getObject(BUCKET_NAME,fileName)
                    .getObjectContent());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String deleteFile(String fileName){
        amazonS3.deleteObject(BUCKET_NAME,fileName);
        return "File is deleted:"+fileName;
    }
}
