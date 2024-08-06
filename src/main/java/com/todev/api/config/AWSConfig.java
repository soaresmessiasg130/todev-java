package com.todev.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.context.annotation.Configuration;

/**
 * AWSConfig
 */
@Configuration
public class AWSConfig {

  @Value("${aws.region}")
  private String awsRegion;

  @Bean
  public AmazonS3 createInstance() {
    return AmazonS3ClientBuilder
      .standard()
      .withCredentials(new DefaultAWSCredentialsProviderChain())
      .withRegion(awsRegion)
      .build();
  }
}
