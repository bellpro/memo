package com.bellpro.memo.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter // Getter 메소드 생성
@MappedSuperclass   // 상속받은 Entity가 자동으로 열로 인식
@EntityListeners(AuditingEntityListener.class)  // 생성/수정 시간 자동으로 업데이트
public abstract class Timestamped {

    @CreatedDate    // 생성시간
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정시간
    private LocalDateTime modifiedAt;
}
