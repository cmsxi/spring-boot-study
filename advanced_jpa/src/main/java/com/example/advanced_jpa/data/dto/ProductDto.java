package com.example.advanced_jpa.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    private String name;
    private int price;
    private int stock;

//    public String getName(){
//        return name;
    // return new ResponseDto(Status.OK);
//     } return ResponseDto.Builder().responseStatus(Status.OK).build();
//
//    public void setName(String name){
//        this.name = name;
//    }
//    lombok 어노테이션을 활용하여 축약 가능

}
