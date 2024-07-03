package com.s3.s3bucket.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsS3BucketConfig {

    private final String ACCESS_KEY="";
    private final String SECRET_KEY="";
    private final String REGION="ap-south-1";


    @Bean
    AmazonS3 s3BucketClient(){
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY,SECRET_KEY)))
                .withRegion(REGION)
                .build();
    }
}
