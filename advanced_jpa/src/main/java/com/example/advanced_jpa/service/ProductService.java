package com.example.advanced_jpa.service;

import com.example.advanced_jpa.data.dto.ProductDto;
import com.example.advanced_jpa.data.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
// DAO에서 구현한 기능을 서비스 인터페이스에서 호출, 결괏값 가져오는 작업 수행하도록 설계
// 서비스: 클라이언트가 요청한 데이터를 적절하게 가공하여 컨트롤러에게 전달
