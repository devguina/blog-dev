package com.spring.codeblog.services;

import com.spring.codeblog.models.PostModel;
import com.spring.codeblog.repositories.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CodeblogServiceImp implements CodeblogService{

    @Autowired
    PostRepository postRepository;


    @Override
    public List<PostModel> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostModel> findById(UUID id) {
        return postRepository.findById(id);
    }

    @Override
    public PostModel save(PostModel postModel) {
        return postRepository.save(postModel);
    }
}
