package com.example.advanced_jpa.controller;

import com.example.advanced_jpa.data.dto.ChangeProductNameDto;
import com.example.advanced_jpa.data.dto.ProductDto;
import com.example.advanced_jpa.data.dto.ProductResponseDto;
import com.example.advanced_jpa.data.dto.ResponseDto;
import com.example.advanced_jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseDto<?> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        if(productResponseDto.getNumber() == null ) {
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    "찾는 값이 없습니다.");
        }
        return new ResponseDto<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), productResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {
        ProductResponseDto productResponseDto = productService.changeProductName(
                changeProductNameDto.getNumber(),
                changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}