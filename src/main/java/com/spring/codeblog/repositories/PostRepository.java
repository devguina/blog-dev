package com.spring.codeblog.repositories;

import com.spring.codeblog.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<PostModel, UUID> {
}
