package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepositoty;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepositoty memoRepositoty;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepositoty.findById(id).orElseThrow(() -> new NullPointerException("아이디가 존재하지 않습니다."));
        memo.update(requestDto);
        return id;
    }
}
