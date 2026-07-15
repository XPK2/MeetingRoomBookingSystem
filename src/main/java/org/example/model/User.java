package org.example.model;

public class User {
    private int id;
    private String email;
    private String fullName;
    private UserRole role;

    public User(int id, String email, String fullName, UserRole userRole) {
        if (email == null) {
            throw new IllegalArgumentException("Email must not be null");
        }

        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = userRole;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email must not be null");
        }

        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole userRole) {
        this.role = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role=" + role +
                '}';
    }
}
