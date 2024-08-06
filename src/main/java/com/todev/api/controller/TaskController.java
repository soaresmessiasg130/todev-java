package com.todev.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.todev.api.domain.task.Task;
import com.todev.api.domain.task.TaskCreateDto;
import com.todev.api.services.TaskService;

/**
 * TaskController
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Task> create(
      @RequestParam(value = "title", required = true) String title,
      @RequestParam(value = "description", required = false) String description,
      @RequestParam(value = "done", required = false) Boolean done,
      @RequestParam(value = "image", required = false) MultipartFile image) {
    var dto = new TaskCreateDto(title, description, done, image);

    var task = this.taskService.createTask(dto);

    return ResponseEntity.ok(task);
  }
}
