package com.GoKloud.Project.Blogging.model;

public class BlogCreationData {
    private Blog blog;
    private Long authorId;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
