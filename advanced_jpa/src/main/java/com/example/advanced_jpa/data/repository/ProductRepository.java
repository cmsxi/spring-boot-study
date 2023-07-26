package com.example.advanced_jpa.data.repository;

import com.example.advanced_jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNumber(long number);
    // 데이터베이스의 테이블과 구조를 생성하는데 엔터티를 사용했다면,
    // 리포지토리는 엔티티가 생성한 데이터베이스에 접근하는데 사용

    // Optional<Student> findBy학번ANd패스워드(스트링2개)

}
