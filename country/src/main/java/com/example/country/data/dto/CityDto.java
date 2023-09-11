package com.example.country.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {

    private Integer cityID;

    private String cityName;

    private String countryCode;

    private String district;

    private Long population;
}
