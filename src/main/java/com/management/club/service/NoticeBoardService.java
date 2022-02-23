package com.management.club.service;

import com.management.club.dto.NoticeBoardRequestDto;
import com.management.club.exception.CustomException;
import com.management.club.exception.ErrorCode;
import com.management.club.model.NoticeBoard;
import com.management.club.repository.NoticeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor //final로 선언된 모든 멤버변수에 대한 생성자를 만들어줌
public class NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;


    //글 작성
    @Transactional
    public Long save(final NoticeBoardRequestDto params) {

        NoticeBoard entity = noticeBoardRepository.save(params.toEntity());
        return entity.getId();
    }

    //글 수정
    @Transactional
    public Long update(final Long id, final NoticeBoardRequestDto params) {
        //영속성 컨텍스트에 있는 (id)값으로 조회 후 값을 변경시키면 Transaction이 종료(commit)되는 시점에 update쿼리를 자동으로 실행함. (더티체킹)

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        NoticeBoard entity = noticeBoardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContent(), authentication.getName());
        return id;
    }


    //상세정보 조회, 조회수 증가
    @Transactional
    public NoticeBoard findById(final Long id) {

        NoticeBoard noticeBoard = noticeBoardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        noticeBoard.increaseHits();
        return noticeBoard;
    }


}
