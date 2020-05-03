package com.arthurtira.studentapidemo.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
        (basePackages = "com.arthurtira.studentapidemo.repository")
public class DynamodbConfiguration {
    /*
    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
    */

    @Value("${amazon.aws.region}")
    private String amazonRegion;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(amazonDynamoDB());
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                //.withCredentials(amazonAWSCredentials())
                .withRegion(amazonRegion)
                .build();
    }

/*
    public AWSCredentialsProvider amazonAWSCredentials() {
        return new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey));
    }*/
}
