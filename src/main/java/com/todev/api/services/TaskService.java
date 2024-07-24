package com.todev.api.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.todev.api.config.AWSConfig;
import com.todev.api.domain.task.Task;
import com.todev.api.domain.task.TaskCreateDto;
import com.todev.api.repositories.TaskRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TaskService
 */
@Service
public class TaskService {

  @Value("${aws.bucket.name}")
  private String bucketName;

  @Autowired
  private AmazonS3 amazonS3Client;

  @Autowired
  private TaskRepository taskRepository;

  public Task createTask(TaskCreateDto data) {
    String imageUrl = null;

    if (data.image() != null) {
      imageUrl = this.uploadFile(data.image());
    }

    Task newTask = new Task();

    newTask.setTitle(data.title());
    newTask.setDescription(data.description());
    newTask.setImageUrl(imageUrl);
    newTask.setDone(data.done());
    newTask.setCreatedAt(new Date());

    var res = this.taskRepository.save(newTask);

    return res;
  }

  private String uploadFile(final MultipartFile file) {
    String filenameToPut = UUID.randomUUID() + "-" + file.getOriginalFilename();

    try {
      File fileToPut = this.convertMultipartToFile(file);

      amazonS3Client.putObject(bucketName, filenameToPut, fileToPut);

      fileToPut.delete();

      return amazonS3Client.getUrl(bucketName, filenameToPut).toString();
    } catch (Exception e) {
      System.out.println("Error at push file to AWS S3 Bucket: " + bucketName);

      return null;
    }
  }

  private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
    String originalFilename = Objects.requireNonNull(multipartFile.getOriginalFilename());

    File newFile = new File(originalFilename);

    FileOutputStream fileOutput = new FileOutputStream(newFile);

    fileOutput.write(multipartFile.getBytes());

	  fileOutput.close();

    return newFile;
  }

}
