package com.demo.service;

import com.demo.domain.entities.Citizen;
import com.demo.domain.models.service.CitizenServiceModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CitizenService {

    List<CitizenServiceModel> findAllCitizens();


    CitizenServiceModel addConfirm(CitizenServiceModel citizenServiceModel);



    CitizenServiceModel findCitizenById(String id);

    void deleteCitizen(String id);


    CitizenServiceModel editCitizen(String id, CitizenServiceModel citizenServiceModel);

    //List<CitizenServiceModel> findAllCities();

   // Page<Citizen> findPaginated(int pageNo, int pageSize);

}
