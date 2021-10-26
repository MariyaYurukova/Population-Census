package com.demo.service;


import com.demo.domain.entities.Citizen;
import com.demo.domain.entities.City;
import com.demo.domain.models.service.CitizenServiceModel;

import com.demo.repository.CitizenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CitizenServiceImpl implements CitizenService{

    private final CitizenRepository citizenRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository, ModelMapper modelMapper) {
        this.citizenRepository = citizenRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public List<CitizenServiceModel> findAllCitizens() {
        return this.citizenRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CitizenServiceModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public CitizenServiceModel addConfirm(CitizenServiceModel citizenServiceModel) {

        Citizen citizen = this.modelMapper.map(citizenServiceModel, Citizen.class);
        return this.modelMapper.map(this.citizenRepository.saveAndFlush(citizen), CitizenServiceModel.class);
    }




    @Override
    public CitizenServiceModel findCitizenById(String id){

      boolean c = this.citizenRepository.findById(id).isPresent();
        return this.modelMapper.map ( c, CitizenServiceModel.class);
    }





    @Override
    public void deleteCitizen(String id) {
        Citizen citizen = this.citizenRepository.findById(id).orElseThrow();
        this.citizenRepository.delete(citizen);


    }


    @Override
    public CitizenServiceModel editCitizen(String id, CitizenServiceModel citizenServiceModel) {
        Citizen citizen = this.citizenRepository.findById(id).orElseThrow();

        citizen.setFirstName(citizenServiceModel.getFirstName());
      //  citizen.setLastName(citizenServiceModel.getLastName());
       // citizen.setCity(citizenServiceModel.getCity());
        return this.modelMapper.map(this.citizenRepository.saveAndFlush(citizen), CitizenServiceModel.class);
    }



//    @Override
//    public List<CitizenServiceModel> findAllCities() {
//        return this.citizenRepository.findAll()
//                .stream()
//                .map(c -> this.modelMapper.map(c, CitizenServiceModel.class))
//                .collect(Collectors.toList());
//    }



//    @Override
//    public Page<Citizen> findPaginated(int pageNo, int pageSize) {
//
//        Pageable pageable = PageRequest.of(pageNo - 1, 9);
//        return this.citizenRepository.findAll(pageable);
//    }


}
