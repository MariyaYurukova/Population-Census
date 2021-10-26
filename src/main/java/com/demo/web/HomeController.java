package com.demo.web;

import com.demo.domain.models.binding.CitizenAddBindingModel;
import com.demo.domain.models.service.CitizenServiceModel;
import com.demo.domain.models.service.CityServiceModel;
import com.demo.domain.models.service.MyResponse;
import com.demo.domain.models.service.TownServiceModel;
import com.demo.domain.models.views.CitizenListViewModel;
import com.demo.domain.models.views.CityListViewModel;
import com.demo.service.CitizenService;
import com.demo.service.CityService;
import com.demo.service.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController extends BaseController{




    private final CitizenService citizenService;
    private final ModelMapper modelMapper;
    private final CityService cityService;
    private final TownService townService;

    @Autowired
    public HomeController(CitizenService citizenService, ModelMapper modelMapper, CityService cityService, TownService townService) {
        this.citizenService = citizenService;
        this.modelMapper = modelMapper;
        this.cityService = cityService;
        this.townService = townService;
    }


    @GetMapping("/")
    public String index(Model model) {
        List<CitizenListViewModel> citizens = this.citizenService.findAllCitizens()
                .stream()
                .map(c -> this.modelMapper.map(c, CitizenListViewModel.class))
                .collect(Collectors.toList());

        model.addAttribute("citizen", citizens);


        return ("index");
    }




    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView, @ModelAttribute(name = "model") CitizenAddBindingModel model) {

        modelAndView.addObject("model", model);
        modelAndView.addObject("city", this.cityService.findAllCities()
                .stream()
                .map(c -> this.modelMapper.map(c, CityListViewModel.class))
                .collect(Collectors.toList()));
        return super.view("add-citizen", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(@ModelAttribute(name = "model") CitizenAddBindingModel model, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {

            modelAndView.addObject("model", model);
            return super.view("add-citizen1", modelAndView);
        }

        CitizenServiceModel citizenServiceModel = this.modelMapper.map(model, CitizenServiceModel.class);
        this.citizenService.addConfirm(citizenServiceModel);

        return super.redirect("/");
    }







    @ResponseBody
    @GetMapping("/allCitizen")
    public List<CitizenServiceModel> citizens() {
        return citizenService.findAllCitizens();
    }


    @ResponseBody
    @GetMapping("/allCities")
    public List<CityServiceModel> cities() {
        return cityService.findAllCities();
    }


    @RequestMapping(value="/city/all/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CityServiceModel> getCity(@PathVariable String id) {
        return new ResponseEntity<CityServiceModel>(cityService.findCityById(id), HttpStatus.OK);
    }


    @RequestMapping(value="/city/all/", params="id")
    @ResponseBody
    public ResponseEntity<CityServiceModel> getByIdFromParam(@RequestParam("id") String id) {

        return new ResponseEntity<CityServiceModel>(cityService.findCityById(id), HttpStatus.OK);
    }


    @GetMapping(value="/{id}")
    @ResponseBody
    public CitizenServiceModel getCitizen( @PathVariable  String id) {
        return this.citizenService.findCitizenById(id);
    }




    @PutMapping("/save/{id}" )
    @ResponseBody
    public ResponseEntity<Void> updateCitizen(@PathVariable String id,  CitizenServiceModel citizenServiceModel) {
   CitizenServiceModel citizen =   citizenService.findCitizenById(id);
       citizenServiceModel.setId(id);
       citizenService.addConfirm(citizen);
        return  ResponseEntity.noContent().build();
    }





    @RequestMapping(value="/", params="id")
    @ResponseBody
    public ResponseEntity<CitizenServiceModel> getByIdFromParams(@RequestParam("id") String id) {

        return new ResponseEntity<CitizenServiceModel>(citizenService.findCitizenById(id), HttpStatus.OK);
    }






    @PostMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteCitizen(@PathVariable String id) {
        citizenService.deleteCitizen(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}















