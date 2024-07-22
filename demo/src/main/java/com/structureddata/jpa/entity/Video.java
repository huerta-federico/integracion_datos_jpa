// Video.java
package com.structureddata.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VIDEO")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VIDEO_ID")
    private int videoId;

    private String title;
    private String description;
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @ManyToMany
    @JoinTable(name = "VIDEO_CATEGORY", joinColumns = @JoinColumn(name = "VIDEO_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private List<Category> categories;

    // getters and setters
    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}