package com.management.club.service;

import com.management.club.dto.BoardRequestDto;
import com.management.club.dto.BoardResponseDto;
import com.management.club.exception.CustomException;
import com.management.club.exception.ErrorCode;
import com.management.club.model.Board;
import com.management.club.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //final로 선언된 모든 멤버변수에 대한 생성자를 만들어줌
public class BoardService {

    private final BoardRepository boardRepository;


    //글 작성
    @Transactional
    public Long save(final BoardRequestDto params) {

        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    //글 수정
    @Transactional
    public Long update(final Long id, final BoardRequestDto params) {
        //영속성 컨텍스트에 있는 (id)값으로 조회 후 값을 변경시키면 Transaction이 종료(commit)되는 시점에 update쿼리를 자동으로 실행함. (더티체킹)

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContent(), authentication.getName());
        return id;
    }

    //게시글 삭제
    @Transactional
    public Long delete(final Long id) {

        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.delete();
        return id;
    }

    //상세정보 조회, 조회수 증가
    @Transactional
    public BoardResponseDto findById(final Long id) {

        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.increaseHits();
        return new BoardResponseDto(entity);
    }


}
