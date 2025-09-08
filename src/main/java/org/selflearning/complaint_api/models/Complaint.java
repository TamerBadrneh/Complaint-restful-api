package org.selflearning.complaint_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.selflearning.complaint_api.constants.ComplaintCategory;
import org.selflearning.complaint_api.constants.ComplaintResolveStatus;
import org.selflearning.complaint_api.validation.annotations.IsComplaintCategory;
import org.selflearning.complaint_api.validation.annotations.IsComplaintResolveStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Complaint {

    private String id;

    @NotBlank(message = "Title can't be blank.")
    @NotNull(message = "Title can't be null.")
    @Length(min = 3, max = 50, message = "Title Length between 3 - 50.")
    private String title;

    @NotBlank(message = "Description can't be blank.")
    @NotNull(message = "Description can't be null.")
    @Length(min = 3, message = "Description Length requires at least 3 characters.")
    private String description;

    @IsComplaintCategory(message = "The Category provided is invalid.")
    private ComplaintCategory category;

    @IsComplaintResolveStatus(message = "The Status provided is invalid.")
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
