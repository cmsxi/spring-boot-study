package com.example.country.service;

import com.example.country.data.dto.CityRequestDto;
import com.example.country.data.entity.City;
import com.example.country.data.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public List<City> getCity(CityRequestDto cityRequestDto){
        if (cityRequestDto.getPopulation() != null) {
            List<City> searchByCountryCodeAndPopulation = cityRepository.findAllByCountryCodeAndPopulation(cityRequestDto.getCountryCode(), cityRequestDto.getPopulation()).orElseGet(()->{
                return null;
            });
            System.out.println("searchByCountryCodeAndPopulation = " + searchByCountryCodeAndPopulation);
            return searchByCountryCodeAndPopulation;
        } else {
            List<City> searchByCountryCode = cityRepository.findAllByCountryCode(cityRequestDto.getCountryCode()).orElseGet(()->{
                return null;
            });

            System.out.println("searchByCountryCode = " + searchByCountryCode);
            return searchByCountryCode;
        }
    }

    public long countCity(CityRequestDto cityRequestDto){
        long countByCountryCode = cityRepository.countByCountryCode(cityRequestDto.getCountryCode());
        return countByCountryCode;
    }

//    public City addCity(){
//        // SQL연동 확인용
//        Integer cityID = 1002;
//        String cityName = "citytyty";
//        String countryCode = "abc";
//        String district = "aaa";
//        int population = 123456;
//        return cityRepository.save(City.builder()
//                .id(cityID)
//                .name(cityName).countryCode(countryCode).district(district).population(population).build());
//    }


}
