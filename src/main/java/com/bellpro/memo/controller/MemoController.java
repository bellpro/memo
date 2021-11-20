package com.bellpro.memo.controller;

import com.bellpro.memo.domain.Memo;
import com.bellpro.memo.domain.MemoRepository;
import com.bellpro.memo.domain.MemoRequestDto;
import com.bellpro.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.management.LockInfo;
import java.util.List;

@RequiredArgsConstructor    // 반드시 필요한 생성자가 있으면 스프링에서 알아서 생성하도록 권한을 주는 것 (반드시 필요한 것에 final을 붙임
@RestController // JSON 데이터를 주고 받는 자동 응답기
public class MemoController {

    private final MemoRepository memoRepository;    // 생성, 조회, 삭제
    private final MemoService memoService;  // 수정

    // 생성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){ // 생성할 데이터 받아야함
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    // 조회
    @GetMapping("/api/memos")
    public List<Memo> getmemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc(); // 최신순으로 정렬해서 리스트 조회
    }

    // 수정
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){ // 수정할 데이터 받아야함
        memoService.update(id, requestDto);
        return id;
    }

    // 삭제
    @DeleteMapping("api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){  // 경로에 있는 변수 사용
        memoRepository.deleteById(id);
        return id;
    }

}
