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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //final로 선언된 모든 멤버변수에 대한 생성자를 만들어줌
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional
    public Long save(final BoardRequestDto params) {

        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    public List<BoardResponseDto> findAll() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList()); //response 객체를 생성해서 리턴해줌.
    }

    @Transactional
    public Long update(final Long id, final BoardRequestDto params) {
        //영속성 컨텍스트에 있는 (id)값으로 조회 후 값을 변경시키면 Transaction이 종료(commit)되는 시점에 update쿼리를 자동으로 실행함. (더티체킹)
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContent(), params.getWriter());
        return id;
    }

}
