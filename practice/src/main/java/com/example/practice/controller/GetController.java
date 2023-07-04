package com.example.practice.controller;

import com.example.practice.dto.MemberDto;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
//@Controller + @ResponseBody
@RequestMapping("/get-api")
public class GetController {
//    1. RequestMapping method 활용하여 get하기
//    RequestMapping은 스프링 4.3 이후로 잘 사용 안 함. 바로 GetMapping같은 어노테이션 사용.
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World!";
    }

//    2. GetMapping 어노테이션 사용
    @GetMapping("/name")
    public String getName(){
        return "Name";
    }

//    3. PathVariable로 URL통해서 변수 받기
    @GetMapping(value = "variable/{variable}")
    public String getVairable(@PathVariable("variable") String var){
        return var;
    }

//    4. RequestParam으로 URL통해서 여러 변수 입력받기
    @GetMapping("/request")
    public String getRequestParam(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

//    5. RequestParam에 Mapping 활용
    @GetMapping("/request-with-mapping")
    public String getRequestPramWithMapping(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

//    6. DTO객체 활용
    @GetMapping("/request-dto")
    public String getRequestParamDto(MemberDto memberDto){
        return memberDto.toString();
    }

}
