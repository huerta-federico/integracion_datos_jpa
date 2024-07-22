package com.datosestructuradosjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "VIDEO_CATEGORY")
public class VideoCategory {
    @EmbeddedId
    private VideoCategoryId id;

    @ManyToOne
    @MapsId("videoId")
    @JoinColumn(name = "VIDEO_ID")
    private Video video;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    // Getters and Setters
    public VideoCategoryId getId() {
        return id;
    }

    public void setId(VideoCategoryId id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
