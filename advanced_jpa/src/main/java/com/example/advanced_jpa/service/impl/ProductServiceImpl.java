package com.example.advanced_jpa.service.impl;

import com.example.advanced_jpa.data.dao.ProductDAO;
import com.example.advanced_jpa.data.dto.ProductDto;
import com.example.advanced_jpa.data.dto.ProductResponseDto;
import com.example.advanced_jpa.data.entity.Product;
import com.example.advanced_jpa.service.ProductService;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number){
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        if(product == null) {
            productResponseDto.setStatusCode(404);
            return productResponseDto;
        }

        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());
        productResponseDto.setStatusCode(200);
        return productResponseDto;

    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto){
        // 전달받은 dto 객체를 통해서 엔티티 객체 생성 및 초기화
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);

        // dao객체로 전달
        // return type을 어떻게 할 지는 고민해봐야함. void로 하든, boolean타입으로 성공 여부를 지정하든
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception{
        // 실제 변경 작업은 DAO에서 진행. 서비스 레이어에서는 해당 메서드를 호출해서 결괏값만 받아옴
        Product changedProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
        productDAO.deleteProduct(number);
    }

}
