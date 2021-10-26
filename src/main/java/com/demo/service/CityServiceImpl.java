package com.demo.service;


import com.demo.domain.entities.City;


import com.demo.domain.models.service.CityServiceModel;

import com.demo.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {



   private final CityRepository cityRepository;
   private final ModelMapper modelMapper;


   @Autowired
    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CityServiceModel saveCity(CityServiceModel cityServiceModel) {

       City city = this.modelMapper.map(cityServiceModel, City.class);
       return this.modelMapper.map(this.cityRepository.saveAndFlush(city), CityServiceModel.class);

    }



    @Override
    public List<CityServiceModel> findAllCities() {
        return this.cityRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CityServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CityServiceModel findCityById(String id) {
       City city = this.cityRepository.findById(id).orElseThrow();
            return this.modelMapper.map ( city, CityServiceModel.class);



        }





}
