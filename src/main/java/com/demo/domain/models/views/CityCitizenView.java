package com.demo.domain.models.views;

import com.demo.domain.entities.Citizen;

import java.util.List;

public class CityCitizenView {

    private     String id;
    private List<Citizen> citizens;

    public CityCitizenView() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
}
