package com.utcn.se.project.model;

import com.utcn.se.project.dto.UserRole;

public class AuthenticatedUser {
    private int userId;
    private String email;
    private UserRole role;

    public AuthenticatedUser(AuthenticatedUserDTOBuilder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.role = builder.role;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public static class AuthenticatedUserDTOBuilder {

        private int userId;
        private String email;
        private UserRole role;

        public AuthenticatedUserDTOBuilder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public AuthenticatedUserDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AuthenticatedUserDTOBuilder role(UserRole role) {
            this.role = role;
            return this;
        }

        public AuthenticatedUser build() {
            return new AuthenticatedUser(this);
        }
    }
}
