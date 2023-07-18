package com.example.restapiservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNumber;

    @OneToMany(mappedBy = "trainer")
    private List<JoinEntity> joinEntities;

    // Конструкторы, геттеры, сеттеры и другие методы

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
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
