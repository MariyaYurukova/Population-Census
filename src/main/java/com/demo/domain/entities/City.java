package com.demo.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "cities")
public class City extends BaseEntity {


 private String name;
 private List<Citizen> citizens;


    public City() {
    }

    @Column(name= "names" )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }






    @OneToMany(
            fetch = FetchType.LAZY, mappedBy = "city"
    )
    @JsonIgnore
    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
}
