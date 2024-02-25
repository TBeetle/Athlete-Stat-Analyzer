package com.example.demo.athlete;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Athlete {
    @Id
    @SequenceGenerator(name = "athlete_sequence",
            sequenceName = "athlete_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "athlete_sequence")
    private Long id;
    private String name;
    private String email;
    private String position;

    private LocalDate dob;
    @Transient
    private Integer age;

    public Athlete() {
    }

    public Athlete(Long id, String name, String email, String position, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.position = position;
        this.dob = dob;
    }

    public Athlete(String name, String email, String position, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", positon='" + position + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
