package com.demo.service;

import com.demo.domain.models.service.CitizenServiceModel;
import com.demo.domain.models.service.CityServiceModel;

import java.util.List;

public interface CityService {

    List<CityServiceModel> findAllCities();

    CityServiceModel findCityById(String id);


    CityServiceModel saveCity( CityServiceModel cityServiceModel);


}
