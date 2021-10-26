package com.demo.service;

import com.demo.domain.models.service.CitizenServiceModel;
import com.demo.domain.models.service.TownServiceModel;

import java.util.List;

public interface TownService {



    TownServiceModel create(TownServiceModel townServiceModel);


    List<TownServiceModel> findAllTowns();


    void deleteTown(String id);

}
