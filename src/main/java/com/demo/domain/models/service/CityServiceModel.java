package com.demo.domain.models.service;

import com.demo.domain.entities.Citizen;

import java.util.List;

public class CityServiceModel {

    private String id;
    private String name;
    private List<Citizen> citizens;

    public CityServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
}
