package com.example.advanced_jpa.data.dao;

import com.example.advanced_jpa.data.entity.Product;

//  DAO: Data Access Object, DB에 접근하기 위한 logic을 관리하는 객체
public interface ProductDAO {
    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
