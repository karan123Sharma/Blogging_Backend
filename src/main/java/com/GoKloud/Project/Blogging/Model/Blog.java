package com.GoKloud.Project.Blogging.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Blog_Table")
public class Blog {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blogId;
	
	@Column(name= "Title")
	private String blogTitle;
	@Column(name = "Content", columnDefinition = "TEXT")
	private String blogContent;
	@Column(name= "Date")
	private String blogDate;
	
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogDate() {
		return blogDate;
	}

	public void setBlogDate(String blogDate) {
		this.blogDate = blogDate;
	}

	public Long getBlogViews() {
		return blogViews;
	}

	public void setBlogViews(Long blogViews) {
		this.blogViews = blogViews;
	}
	
	@Column(name="views")
	private Long blogViews;
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
}
