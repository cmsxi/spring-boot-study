package com.example.country.controller;

import com.example.country.data.dto.CityRequestDto;
import com.example.country.data.entity.City;
import com.example.country.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }


    @PostMapping("/search")
    public List<City> searchCity(@RequestBody CityRequestDto cityRequestDto){
        System.out.println(cityRequestDto.getCountryCode());
        return cityService.getCity(cityRequestDto);
    }

    @PostMapping("/count-cc")
    public long CountCity(@RequestBody CityRequestDto cityRequestDto){
        return cityService.countCity(cityRequestDto);
    }

    @PostMapping("/search-cc-p")
    public List<City> searchCityByCountryCodeAndPopulation(@RequestBody CityRequestDto cityRequestDto){
        System.out.println(cityRequestDto.getCountryCode() + cityRequestDto.getPopulation());
        return cityService.getCity(cityRequestDto);
    }

//    @GetMapping("/add")
//    //SQL 연결 확인용
//    public City addCity(){
//        return cityService.addCity();
//    }
}
