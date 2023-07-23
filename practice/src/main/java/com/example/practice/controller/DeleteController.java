package com.example.practice.controller;


import org.springframework.web.bind.annotation.*;

@RequestMapping("/delete-api")
@RestController
public class DeleteController {

//    컨트롤러에서 값을 받을 때는 간단한 값을 받기 때문에, GET 메서드와 같이 URI에 값을 넣어 요청을 받는 형식으로 구현
//    1. PathVariable로 입력값 return
    @DeleteMapping("/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

//    2. RequestParam으로 입력값 return
    @DeleteMapping("/request")
    public String DeleteEmail(@RequestParam String email){
        System.out.println(email);
        return "E-mail: " + email;
    }



}
