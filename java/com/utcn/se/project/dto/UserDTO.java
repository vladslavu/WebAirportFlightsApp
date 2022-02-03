package com.utcn.se.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "user")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private UserRole role;

    public UserDTO() {
    }

    public UserDTO(int idUser, String username, String password, String email, UserRole role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDTO(int idUser, String username, String password, String email, String role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = UserRole.of(role);
    }

    //NEW
    public UserDTO(String username, String password, UserRole role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDTO(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = UserRole.of(role);
    }

    public UserDTO(UserBuilder builder) {
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
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return getIdUser() == userDTO.getIdUser() && Objects.equals(getUsername(), userDTO.getUsername()) && Objects.equals(getPassword(), userDTO.getPassword()) && Objects.equals(getEmail(), userDTO.getEmail()) && getRole() == userDTO.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getUsername(), getPassword(), getEmail(), getRole());
    }

    @Override
    public String toString() {
        return "UserDTO{" +
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

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
