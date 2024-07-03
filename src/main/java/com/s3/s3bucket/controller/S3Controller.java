package com.s3.s3bucket.controller;

import com.s3.s3bucket.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class S3Controller {

    private S3Service service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file")MultipartFile file){
        return ResponseEntity.ok(service.upload(file));
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable String fileName){
        byte[] data=service.download(fileName);
        ByteArrayResource bar=new ByteArrayResource(data);
        return ResponseEntity.ok()
                .contentLength(data.length)
                .header("Content-type","application/octet-stream")
                .header("Content-disposition","attachment:filename=\""+fileName+"\"")
                .body(bar);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName){
        return ResponseEntity.ok(service.deleteFile(fileName));
    }
}
