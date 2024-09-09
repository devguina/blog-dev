package com.spring.codeblog.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_POST")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @NotBlank
    private String title;


    @NotBlank
    private String author;


    @NotBlank
    private LocalDate datePost;

    @NotBlank
    private String textPost;

    public PostModel(){

    }

    public PostModel(UUID id, String title, String author, LocalDate datePost, String textPost) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.datePost = datePost;
        this.textPost = textPost;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDatePost() {
        return datePost;
    }

    public void setDatePost(LocalDate datePost) {
        this.datePost = datePost;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostModel postModel = (PostModel) o;
        return Objects.equals(id, postModel.id) && Objects.equals(title, postModel.title) && Objects.equals(author, postModel.author) && Objects.equals(datePost, postModel.datePost) && Objects.equals(textPost, postModel.textPost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, datePost, textPost);
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", datePost=" + datePost +
                ", textPost='" + textPost + '\'' +
                '}';
    }

}
