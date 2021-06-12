package com.mvcblogs.blog.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Comment {
	private @Id @GeneratedValue Long id;
	@NotBlank(message = "Message is mandatory")
    private String message;
	@CreationTimestamp
	private Date createdAt = new Date();
	@UpdateTimestamp
	private Date updatedAt = new Date();
	
	public Comment() {}
	
	public Comment(String message) {
	    this.message = message;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
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
	
	@ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

}
