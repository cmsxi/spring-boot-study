package com.example.test.controller;

//import com.google.gson.Gson;
// import가 안됨. 의존성 주입해도 안되고, 라이브러리 jar파일 직접 다운로드해도 안 됨
import com.example.test.data.dto.ProductDto;
import com.example.test.data.dto.ProductResponseDto;
import com.example.test.service.impl.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class) // WebMvcTest(테스트 대상 클래스.class): 웹에서 사용되는 요청과 응답에 대해 테스트 수행 가능
// 대상 클래스만 로드하여 테스트 수행, 만일 대상 클래스를 추가하지 않으면 컨트롤러 관련 빈 객체 모두 로드, SpringBootTest보다 가볍게 테스트하기 위해 사용
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc; // MockMvc: 컨트롤러의  API를 테스트하기 위해 사용된 객체. 서블렛 컨테이너의 구동없이 가상의 MVC 환경에서 모의 http 서블릿 요청하는 유틸리티 클래스

    @MockBean // 실제 빈 객체가 아닌 가짜 빈 객체를 생성하여 주입하는 역할 수행. 실제 행위를 수행하지는 않음. 따라서 해당 객체는 Mockito의 given() 메서드를 통해 동작 정의
    ProductServiceImpl productService;

    @Test
    @DisplayName("Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception{
        given(productService.getProduct(123L)).willReturn(
                new ProductResponseDto(123L, "pen", 5000, 2000, 200));

        String productId = "123";

        mockMvc.perform( // 서버로 URL 요청을 보내는 것처럼 통신 테스트 코드를 작성해서 컨트롤러 테스트 가능
                get("/product?number=" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andDo(print());

        verify(productService).getProduct(123L); // 지정된 메서드가 실행됐는지 검증하는 역할
    }

    @Test
    @DisplayName("Product 데이터 생성 테스트")
    void createProductTest() throws Exception{
        given(productService.saveProduct(new ProductDto("pen", 5000, 2000))).willReturn(
                new ProductResponseDto(12315L, "pen", 5000, 2000, 200));

        ProductDto productDto = ProductDto.builder()
                .name("pen")
                .price(5000)
                .stock(2000)
                .build();


//        Gson gson = new Gson();
//        String content = gson.toJson(productDto);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(productDto);
        // ★gson 안돼서 objectmapper 사용했는데 제대로 잘 작동하는지 모름. 추후 확인


        mockMvc.perform( // 서버로 URL 요청을 보내는 것처럼 통신 테스트 코드를 작성해서 컨트롤러 테스트 가능
                        post("/product")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andDo(print());

        verify(productService).saveProduct(new ProductDto("pen", 5000, 2000)); // 지정된 메서드가 실행됐는지 검증하는 역할
    }
}

// 일반적으로 WebMvcTest 어노테이션을 통한 테스트는 슬라이스 테스트라 부름 -> 단위 테스트와 통합 테스트의 중간 정도
// 단위 테스트 수행을 위해 모든 외부 요인을 배제할 경우 웹의 의미를 상실할 수 있어서 슬라이스 테스트를 진행하는 경우가 많음


// ★다음과 같은 에러가 생기는데 왜 생기는지 모르겠음..
// OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
