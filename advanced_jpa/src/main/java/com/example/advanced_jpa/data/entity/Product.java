package com.example.advanced_jpa.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity // 해당 클래스가 엔티티임을 명시
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode //
@ToString(exclude = "name") //
@Table(name = "product") // 클래스 이름과 테이블 이름 다르게 지정할 때 사용. 명시하지 않으면 클래스 이름이 동일하다는 걸 의미
// 자바의 명명법과 DB의 명명법이 다르기 때문에 주로 사용하는 어노테이션임
public class Product {
    @Id // 엔티티 클래스의 필드는 테이블의 칼럼과 매핑. ID 어노테이션이 선언된 필드는 테이블의 기본값 역할
    // 모든 엔티티는 ID 어노테이션이 필요함.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id 어노테이션과 함께 사용. 해당 필드값 어떻게 자동 생성할 지 결정할 때 사용
    private Long number;

    @Column(nullable = false) // 꼭 안써도 되지만 추가 설정 더할 때 사용
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // @Transient: 엔티티에 선언되어 있는 필드지만 db에서 필요 없을 경우 사용

}
