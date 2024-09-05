package com.spring.codeblog.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PostRecordDto(@NotBlank String title, @NotBlank String author, @NotBlank String textPost) {
}
