package com.mvcblogs.blog.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Post {

  private @Id @GeneratedValue Long id;
  @NotBlank(message = "Title is mandatory")
  private String title;
  @NotBlank(message = "Description is mandatory")
  private String description;
  
  @CreationTimestamp
  private Date createdAt = new Date();
  
  @UpdateTimestamp
  private Date updatedAt = new Date();

  public Post() {}

  public Post(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public Long getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  public Date getCreatedAt() {
	return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
	return updatedAt;
  }
	
  public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
  }
  
  public List<Comment> getComments() {
	return comments;
  }
	
  public void setComments(List<Comment> comments) {
	this.comments = comments;
  }

  @OneToMany(mappedBy = "post")
  private List<Comment> comments;
}