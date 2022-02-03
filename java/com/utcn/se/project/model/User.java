package com.utcn.se.project.model;

import com.utcn.se.project.dto.UserRole;

import java.util.Objects;

public class User {
    private int idUser;
    private String username;
    private String password;
    private String email;

    private UserRole role;

    public User() {
    }

    public User(int idUser, String username, String password, String email, UserRole role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password, UserRole role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(UserBuilder builder) {
        this.idUser = builder.idUser;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.role = builder.role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getIdUser() == user.getIdUser() && Objects.equals(getUsername(),
                user.getUsername()) && Objects.equals(getPassword(),
                user.getPassword()) && Objects.equals(getEmail(),
                user.getEmail()) && getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getUsername(), getPassword(), getEmail(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    public static class UserBuilder {
        private int idUser;
        private String username;
        private String password;
        private String email;
        private UserRole role;

        public UserBuilder idUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder role(UserRole role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
