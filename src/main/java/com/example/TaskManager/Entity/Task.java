package com.example.TaskManager.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;


    @Column()
    private String description;


    @NotNull(message = "Status is required")
    @Pattern(regexp = "Pending|In Progress|Completed", message = "Status must be one of 'Pending', 'In Progress', or 'Completed'")
    private String status;

    @Column(name = "created_At", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    // Getters and Setters


    public Task() {}
    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;

    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }



    // PrePersist lifecycle callback to set timestamps before saving to DB
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // PreUpdate lifecycle callback to update the timestamp before an update


}