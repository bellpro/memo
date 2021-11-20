package com.bellpro.memo.service;

import com.bellpro.memo.domain.Memo;
import com.bellpro.memo.domain.MemoRepository;
import com.bellpro.memo.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // 반드시 필요한 생성자가 있으면 스프링에서 알아서 생성하도록 권한을 주는 것 (반드시 필요한 것에 final을 붙임)
@Service    // 클래스가 서비스임을 명시
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional // DB에 쿼리가 일어나야 함을 알림
    public Long update(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(                // 해당 id의 메모 조회
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(memoRequestDto);    // 받은 dto 정보로 메모 업데이트
        return memo.getId();
    }
}
