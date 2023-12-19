package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepositoty extends JpaRepository<Memo, Long> {
    //findAllByOrderByModifiedAtDesc 원래 이렇게인데 하루전~ 현시각까지로 수정
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start,LocalDateTime end);
}
