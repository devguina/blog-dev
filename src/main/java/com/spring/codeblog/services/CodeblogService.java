package com.spring.codeblog.services;

import com.spring.codeblog.models.PostModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CodeblogService {
    List<PostModel> findAll();
    Optional<PostModel> findById(UUID id);
    PostModel save (PostModel postModel);
}
