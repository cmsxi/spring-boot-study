package com.example.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {
    @BeforeAll // 테스트 시작 전 호출되는 메서드 정의
    static void beforeAll(){
        System.out.println("## BeforeAll Annotation 호출##");
        System.out.println();
    }

    @AfterAll // 테스트가 종료되며 호출되는 메서드 정의
    static void afterAll(){
        System.out.println("## AfterAll Annotation 호출##");
        System.out.println();
    }
    // BeforeAll과 AfterAll은 전체 테스트 동작에서 처음과 마지막에만 각각 수행

    @BeforeEach // 각 테스트 메서드가 실행되기 전에 동작하는 메서드 정의
    void beforeEach(){
        System.out.println("## BeforeEach Annotation 호출##");
        System.out.println();
    }

    @AfterEach // 각 테스트 메서드가 종료되며 호출되는 메서드 정의
    void afterEach(){
        System.out.println("## AfterEach Annotation 호출##");
        System.out.println();
    }

    // BeforeEach, AfterEach는 각 테스트가 실행될 때 @Test 어노테이션이 지정된 테스트 메서드를 기준으로 실행

    @Test // 테스트 코드를 포함한 메서드 정의
    void test1(){
        System.out.println("## test1 시작 ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2") // 테스트 메서드의 이름이 복잡해서 가독성이 떨어질 경우 해당 어노테이션으로 테스트 표현 정의 가능
    void test2(){
        System.out.println("## test2 시작 ##");
        System.out.println();
    }

    @Test
    @Disabled
    // Disabled가 지정된 메서드는 실행되지 않음 -> @BeforeEach, @AfterEach 둘 다 실행되지 않음.
    // 그러나 Test 메서드로는 인식되어 disable(비활성화)되었다는 로그 출력
    void test3(){
        System.out.println("## test3 시작 ##");
        System.out.println();
    }
}
