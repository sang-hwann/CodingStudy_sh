package com.example.week04.models;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter //get함수를 자동생성
@MappedSuperclass // 멤버 변수가 컬럼이 되도록함
@EntityListeners(AuditingEntityListener.class)//변경되었을 때 자동으로 기록한다
public abstract class Timestamped {
    @CreatedDate//최초 생성시점
    private LocalDateTime createdAt;
    @LastModifiedDate //마지막 변경시점
    private LocalDateTime modifiedAt;
}
