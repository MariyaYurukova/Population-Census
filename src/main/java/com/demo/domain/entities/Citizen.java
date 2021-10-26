package com.demo.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name= "citizens")
public class Citizen extends BaseEntity{

    private String firstName;
    private String lastName;
    private String egn;
    private City city;
    private String education;
    private Integer age;
    private LocalDate today;

    public Citizen() {

    }

    @Column(name= "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name= "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Column(name= "EGN")
    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }











 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "city_id")
 @JsonIgnore
 public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }






    @Column(name= "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Column(name= "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name= "day")
    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }


    @Override
    public String toString() {
        return "Citizen{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", egn=" + egn +
                ", city=" + city +
                ", education='" + education + '\'' +
                ", age=" + age +
                ", today=" + today +
                '}';
    }
}
