package com.spring.codeblog.controllers;


import com.spring.codeblog.models.PostModel;
import com.spring.codeblog.repositories.PostRepository;
import com.spring.codeblog.services.CodeblogService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class CodeblogController {

    @Autowired
    CodeblogService codeblogService;


    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<PostModel> posts = codeblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id")UUID id){
        ModelAndView mv = new ModelAndView("postDetails");
        Optional<PostModel> posts = codeblogService.findById(id);
        mv.addObject("post", posts);
        mv.addObject("title",posts.get().getTitle());
        mv.addObject("author", posts.get().getAuthor());
        mv.addObject("datePost", posts.get().getDatePost());
        mv.addObject("textPost", posts.get().getTextPost());
        return mv;
    }
    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }
    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid PostModel postModel, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
           attributes.addFlashAttribute("message", "Verifique se os Campos obrigatórios foram preenchidos");
           return "redirect:/newpost";
        }
        postModel.setDatePost(LocalDate.now());
        codeblogService.save(postModel);
        return "redirect:/posts";
    }
}
