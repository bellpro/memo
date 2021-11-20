package com.bellpro.memo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // Getter 메소드 생성
@NoArgsConstructor  // 기본 생성자 생성
@Entity // 테이블과 연결
public class Memo extends Timestamped { // 상속받음

    // ID 열 (기본키)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 작성자 열
    @Column(nullable = false)
    private String username;

    // 작성내용 열
    @Column(nullable = false)
    private String contents;

    // 생성자
    public Memo(String username, String contents){
        this.username = username;
        this.contents = contents;
    }
}
