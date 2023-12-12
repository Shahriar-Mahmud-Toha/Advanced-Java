package dev.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int Id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String quota;
    private String country;

    public Student() {
    }

    public Student(int id, String name, String email, LocalDate dateOfBirth, Gender gender, String quota, String country) {
        Id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.quota = quota;
        this.country = country;
    }
// Overloaded Constructor for retrieval from database
    public Student(int id, String name, String email, LocalDate dateOfBirth, String gender, String quota, String country) {
        Id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        if(gender.equals(Gender.MALE.toString())){
            this.gender = Gender.MALE;
        }
        else{
            this.gender = Gender.FEMALE;
        }
        this.quota = quota;
        this.country = country;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
