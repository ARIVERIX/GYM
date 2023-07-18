package com.example.restapiservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long administratorId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNumber;

    @OneToMany(mappedBy = "administrator")
    private List<JoinEntity> joinEntities;

    // Конструкторы, геттеры, сеттеры и другие методы

    public Long getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Long administratorId) {
        this.administratorId = administratorId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<JoinEntity> getJoinEntities() {
        return joinEntities;
    }

    public void setJoinEntities(List<JoinEntity> joinEntities) {
        this.joinEntities = joinEntities;
    }
}
