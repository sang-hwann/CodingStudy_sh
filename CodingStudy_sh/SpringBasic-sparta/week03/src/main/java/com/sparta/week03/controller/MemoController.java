package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepositoty;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoRepositoty memoRepositoty;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepositoty.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
        LocalDateTime now = LocalDateTime.now(); //현재 시각
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1); // 어제 , -24시
        return memoRepositoty.findAllByModifiedAtBetweenOrderByModifiedAtDesc(yesterday, now);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepositoty.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }


}
