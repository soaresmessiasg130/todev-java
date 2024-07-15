package com.todev.api.services;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.todev.api.domain.task.Task;
import com.todev.api.domain.task.TaskCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TaskService
 */
@Service
public class TaskService {

  public Task createTask(TaskCreateDto data) {
    String imageUrl = null;

    if (data.image() != null) {
      imageUrl = this.uploadImg(data.image());
    }

    Task newTask = new Task();
    newTask.setTitle(data.title());
    newTask.setDesc(data.desc());
    newTask.setImageUrl(imageUrl);
    newTask.setDone(data.done());
    newTask.setCreatedAt(new Date());
  }

  private String uploadImg(final MultipartFile image) {
    return "";
  }
}
