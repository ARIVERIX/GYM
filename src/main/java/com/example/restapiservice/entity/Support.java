package com.example.restapiservice.entity;

import com.example.restapiservice.entity.JoinEntity;
import jakarta.persistence.*;

@Entity
public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supportId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "join_entity_id")
    private JoinEntity joinEntity;

    // Конструкторы, геттеры, сеттеры и другие методы

    public Long getSupportId() {
        return supportId;
    }

    public void setSupportId(Long supportId) {
        this.supportId = supportId;
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

    public JoinEntity getJoinEntity() {
        return joinEntity;
    }

    public void setJoinEntity(JoinEntity joinEntity) {
        this.joinEntity = joinEntity;
    }
}
