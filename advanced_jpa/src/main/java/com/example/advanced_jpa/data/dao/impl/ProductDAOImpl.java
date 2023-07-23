package com.example.advanced_jpa.data.dao.impl;

import com.example.advanced_jpa.data.dao.ProductDAO;
import com.example.advanced_jpa.data.entity.Product;
import com.example.advanced_jpa.data.repository.ProductRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component // component or service 어노테이션을 사용하면 스프링이 관리하는 bean으로 등록할 수 있음
// 빈으로 등록된 객체는 다른 클래스가 인터페이스를 가지고 의존성을 주입받을 때 이 구현체를 찾아 주입하게 됨
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    // DB에 접근하기 위해서 14~19 line 처럼 리포지토리를 정의하고 생성자를 통해 의존성 주입을 받아야 함

    @Override
    public Product insertProduct(Product product){
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number){
        Product selectedProduct = productRepository.getReferenceById(number);

        return selectedProduct;
    }

    @Transactional // 해당 메서드 내 작업을 마칠 경우 자동으로 flush() 메서드를 실행
    // 이 과정에서 변경이 감지되면 대상 객체에 해당하는 db 레코드를 업데이트 하는 쿼리가 실행됨
    @Override
    public Product updateProductName(Long number, String name) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        }else{
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
        Optional<Product> selectProduct = productRepository.findById(number);

        if(selectProduct.isPresent()) {
            Product product = selectProduct.get();

            productRepository.delete(product);
        } else{
            throw new Exception();
        }

    }

}
