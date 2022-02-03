package com.utcn.se.project.model;

import java.util.Objects;

public class StaffMember {
    private int idStaffMember;
    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private int workExperience;

    public StaffMember() {
    }

    public StaffMember(int idStaffMember, String firstName, String lastName, int age, String nationality, int workExperience) {
        this.idStaffMember = idStaffMember;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.workExperience = workExperience;
    }

    public StaffMember(String firstName, String lastName, int age, String nationality, int workExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.workExperience = workExperience;
    }

    public StaffMember(StaffMemberBuilder builder) {
        this.idStaffMember = builder.idStaffMember;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.nationality = builder.nationality;
        this.workExperience = builder.workExperience;
    }

    public int getIdStaffMember() {
        return idStaffMember;
    }

    public void setIdStaffMember(int idStaffMember) {
        this.idStaffMember = idStaffMember;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffMember)) return false;
        StaffMember that = (StaffMember) o;
        return getIdStaffMember() == that.getIdStaffMember() && getAge() == that.getAge() && getWorkExperience() == that.getWorkExperience() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getNationality(), that.getNationality());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdStaffMember(), getFirstName(), getLastName(), getAge(), getNationality(), getWorkExperience());
    }

    @Override
    public String toString() {
        return "StaffMember{" +
                "idStaffMember=" + idStaffMember +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }

    public static class StaffMemberBuilder {
        private int idStaffMember;
        private String firstName;
        private String lastName;
        private int age;
        private String nationality;
        private int workExperience;

        public StaffMemberBuilder idStaffMember(int idStaffMember) {
            this.idStaffMember = idStaffMember;
            return this;
        }

        public StaffMemberBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StaffMemberBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StaffMemberBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StaffMemberBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public StaffMemberBuilder workExperience(int workExperience) {
            this.workExperience = workExperience;
            return this;
        }

        public StaffMember build() {
            return new StaffMember(this);
        }
    }
}
