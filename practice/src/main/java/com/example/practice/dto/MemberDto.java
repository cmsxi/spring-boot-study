package com.example.practice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;
@Getter
@Setter
public class MemberDto {
    private String name;
    private String email;
    private String organization;
    
//    아래 주석부분 @Getter, @Setter로 대체 가능하다
//    public String getName(){
//        return name;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public String getEmail(){
//        return email;
//    }
//    public void setEmail(String email){
//        this.email = email;
//    }
//
//    public String getOrganization(){
//        return organization;
//    }
//
//    public void setOrganization(String organization){
//        this.organization = organization;
//    }

    @Override
    public String toString(){
        return "MemberDto{" + "name: " + name + ", email: " + email + ", organization: " + organization + "}";
    }

}
