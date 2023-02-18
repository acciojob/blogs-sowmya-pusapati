package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name="Image")
public class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    private String description;
    private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog_id;

    public Image() {
    }

    public Image(int imageId, String description, String dimensions) {
        this.imageId = imageId;
        this.description = description;
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog_id;
    }

    public void setBlog(Blog blog) {
        this.blog_id = blog;
    }

    public int getId() {
        return imageId;
    }

    public void setId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}