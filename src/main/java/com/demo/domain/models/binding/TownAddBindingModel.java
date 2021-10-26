package com.demo.domain.models.binding;

import com.demo.domain.entities.Citizen;

import java.util.List;

public class TownAddBindingModel {


    private String country;
    private String egn;
    private String lastName;



    public TownAddBindingModel() {
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
