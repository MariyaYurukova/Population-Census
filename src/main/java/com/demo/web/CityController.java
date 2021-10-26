package com.demo.web;


import com.demo.domain.models.binding.CityAddBindingModel;
import com.demo.domain.models.service.CityServiceModel;
import com.demo.domain.models.views.CityListViewModel;

import com.demo.service.CityService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/city")
public class CityController extends BaseController{


    private final CityService cityService;
    private final ModelMapper modelMapper;


    @Autowired
    public CityController(CityService cityService, ModelMapper modelMapper) {
        this.cityService = cityService;
        this.modelMapper = modelMapper;

    }


    @GetMapping("/all")
    public String cit(Model model) {
        List<CityListViewModel> cities = this.cityService.findAllCities()
                .stream()
                .map(c -> this.modelMapper.map(c, CityListViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("city", cities);



       return ("city/cities");
    }









    @GetMapping("/addCity" )
     public ModelAndView addCOm(ModelAndView modelAndView, @ModelAttribute(name= "model") CityAddBindingModel cityAddBindingModel){
        modelAndView.addObject("model", cityAddBindingModel);

       return super.view("city/add-city", modelAndView);
    }




     @PostMapping("/addCity")
    public ModelAndView addCOm(@ModelAttribute(name = "model") CityAddBindingModel cityAddBindingModel, BindingResult bindingResult, ModelAndView modelAndView)  {
        if(bindingResult.hasErrors()) {

            modelAndView.addObject("model",cityAddBindingModel);
            return super.view("city/add-city", modelAndView);
        }

        CityServiceModel cityServiceModel = this.modelMapper.map(cityAddBindingModel, CityServiceModel.class);
        this.cityService.saveCity(cityServiceModel);


         return  super.redirect("/");
    }









}













