package com.bellpro.memo.domain;

import lombok.Getter;

@Getter // Getter 메소드 생성
public class MemoRequestDto {
    private String username;
    private String contents;
}
