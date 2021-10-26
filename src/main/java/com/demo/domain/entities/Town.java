package com.demo.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "countries")
public class Town extends BaseEntity{


    private String country;
    private Long egn;
    private String lastName;


    public Town() {
    }

    @Column(name= "country" )
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Column(name= "egn" )
    public Long getEgn() {
        return egn;
    }

    public void setEgn(Long egn) {
        this.egn = egn;
    }








    @Column(name= "last_name" )
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
