package com.example.practice.controller;

import com.example.practice.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/put-api")
@RestController
public class PutController {


//    1. PutMapping 사용
    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        System.out.println(sb.toString());

        return sb.toString();
    }

//    2. return 값이 memberDto class에서 정한 String 출력 형식
    @PutMapping("/member-dto1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

//    3. return값이 memberDto, @RestController어노테이션으로 지정한 클래스이기 때문에 @ResponseBody가 생략되어 있으므로
//    자동으로 값을 받아올때  JSON과 같은 형식으로 변환해서 전달하게 됨
    @PutMapping("/member-dto2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

//    4. ResponseEntity 활용, HTTP 응답코드가 202로 나오게 된다('HttpStatus.ACCEPTED'로 했기 때문에)
    @PutMapping("/member-dto3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
