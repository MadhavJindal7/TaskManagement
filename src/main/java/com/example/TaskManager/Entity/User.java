package com.example.TaskManager.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Timezone is mandatory")
    private String timezone;

    @NotNull(message = "isActive is mandatory")
    private Boolean isActive;

    // Constructors, Getters, and Setters
    public User() {}

    public User(String firstName, String lastName, String timezone, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.timezone = timezone;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
