package com.structureddata.jpa.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

// Clase no utilizada por el momento.
@Embeddable
public class VideoCategoryId implements Serializable {
    private int videoId;
    private int categoryId;

    // Getters, Setters, hashCode, equals
    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoCategoryId that = (VideoCategoryId) o;
        return videoId == that.videoId &&
                categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoId, categoryId);
    }
}
