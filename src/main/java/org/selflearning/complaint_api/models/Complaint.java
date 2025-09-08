package org.selflearning.complaint_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.selflearning.complaint_api.constants.ComplaintCategory;
import org.selflearning.complaint_api.constants.ComplaintResolveStatus;

public class Complaint {

    private String id;
    private String title;
    private String description;
    private ComplaintCategory category;
    private ComplaintResolveStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Complaint() {
        this.setId(UUID.randomUUID().toString());
        this.setCategory(ComplaintCategory.OTHER);
        this.setCreatedAt(LocalDateTime.now());
        this.setStatus(ComplaintResolveStatus.OPENED);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComplaintCategory getCategory() {
        return this.category;
    }

    public void setCategory(ComplaintCategory category) {
        this.category = category;
    }

    public ComplaintResolveStatus getStatus() {
        return this.status;
    }

    public void setStatus(ComplaintResolveStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other == this)
            return true;

        if (!(other instanceof Complaint))
            return false;

        return ((Complaint) other).getId().equals(this.getId());
    }

}
