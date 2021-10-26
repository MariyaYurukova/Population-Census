package com.demo.web;



import com.demo.domain.models.service.MyResponse;
import com.demo.domain.models.service.TownServiceModel;
import com.demo.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/abroad")
public class AbroadController extends BaseController{



  private final  TownService townService;


  @Autowired
    public AbroadController(TownService townService) {
        this.townService = townService;
    }


    @GetMapping("/")
    public String abroad() {
        return ("abroad");

    }



    @PostMapping("/addTown")
    @ResponseBody
    public ResponseEntity<Object> addTown(@RequestBody TownServiceModel townServiceModel) {
        townService.create(townServiceModel);
        MyResponse<TownServiceModel> response = new MyResponse<>("success", townServiceModel);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/allCountry")
    public List<TownServiceModel> towns() {
        return townService.findAllTowns();
    }



    @PostMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteCitizen(@PathVariable String id) {
        townService.deleteTown(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping( value = "/save" )
    @ResponseBody
    public ResponseEntity<Void> saveOrUpdateCountry(@RequestBody TownServiceModel townServiceModel) {
       townService.create(townServiceModel);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}