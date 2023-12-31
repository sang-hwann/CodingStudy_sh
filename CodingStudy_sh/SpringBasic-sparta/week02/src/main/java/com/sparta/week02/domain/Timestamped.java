package com.sparta.week02.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass//상속했을떄, 컬럼으로 인식하게한다. 즉 밑의 timestamped를 상속시 이걸 컬럼으로 만들어줘라
//EntityListeners라는 것은 주시하라는 의미로 있는거임
@EntityListeners(AuditingEntityListener.class)//생성,수정 시간을 자동으로 반영하도록 설정
public abstract class Timestamped {
    //abstract의 의미는 상속으로 사용이 가능하다는 의미이다.
    @CreatedDate //생성일자를 나타냄
    private LocalDateTime createdAt;

    @LastModifiedDate //마지막 수정일자임을 나타냄
    private LocalDateTime modifiedAt; //EntityListeners에서 확인하면서 수정일자를 수정
}
