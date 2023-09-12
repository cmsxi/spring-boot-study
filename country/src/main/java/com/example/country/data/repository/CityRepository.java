package com.example.country.data.repository;

import com.example.country.data.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    // JpaRepository는 특정 엔티티 클래스에 대해 JPA 작업을 수행하는데 필요한 메소드를 제공하는 인터페이스
    // City는 엔티티 클래스를 나타냄
    // Integer는 엔티티 클래스의 ID 필드의 타입을 나타냄 - 기본 키(primary key)
    // 따라서 City라는 객체의 기본키 타입은 integer
    Optional<List<City>> findAllByCountryCode(String countryCode);
    // find, exists 와 같은 키워드로 쿼리 주제를 정하며 By는 서술어의 시작을 나타내는 구분자 역할
    // And나 Or 사용해 조건 확장 또한 가능함

    Optional<List<City>> findAllByCountryCodeAndPopulation(String countryCode, int population);

    long countByCountryCode(String countryCode);

    Optional<List<City>> findFirst5ByCountryCode(String countryCode);
    // 5개의 결과만 보이게 하고 싶을 때 활용

}
