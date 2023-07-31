package com.example.test.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

    private int statusCode;
}