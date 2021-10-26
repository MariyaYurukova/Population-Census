package com.demo.service;


import com.demo.domain.entities.Citizen;
import com.demo.domain.entities.City;
import com.demo.domain.entities.Town;
import com.demo.domain.models.service.CityServiceModel;
import com.demo.domain.models.service.TownServiceModel;
import com.demo.repository.TownRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServiceImp implements TownService{

  private final TownRepository townRepository;
  private final ModelMapper modelMapper;


  @Autowired
    public TownServiceImp(TownRepository townRepository, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public TownServiceModel create(TownServiceModel townServiceModel) {
      Town town = this.modelMapper.map(townServiceModel, Town.class);

      return this.modelMapper.map(this.townRepository.saveAndFlush(town), TownServiceModel.class);
    }


  @Override
  public List<TownServiceModel> findAllTowns() {
    return this.townRepository.findAll()
            .stream()
            .map(t -> this.modelMapper.map(t, TownServiceModel.class))
            .collect(Collectors.toList());
  }
  @Override
  public void deleteTown(String id) {
    Town town = this.townRepository.findById(id).orElseThrow();
    this.townRepository.delete(town);


  }

}

