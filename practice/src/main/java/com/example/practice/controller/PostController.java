package com.example.practice.controller;

import com.example.practice.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/post-api")
public class PostController {

//    1. PostMapping 어노테이션 사용
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

//    2. DTO객체 활용
    @PostMapping("/member-dto")
    public String postMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }


}

