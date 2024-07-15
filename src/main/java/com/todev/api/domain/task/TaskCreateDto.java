package com.todev.api.domain.task;

import org.springframework.web.multipart.MultipartFile;

public record TaskCreateDto(String title, String desc, Boolean done, MultipartFile image) {
}
