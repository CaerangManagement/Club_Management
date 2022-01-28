package com.management.club.service;

import com.management.club.dto.BoardRequestDto;
import com.management.club.exception.CustomException;
import com.management.club.exception.ErrorCode;
import com.management.club.model.Board;
import com.management.club.model.Reply;
import com.management.club.model.UserInfo;
import com.management.club.repository.BoardRepository;
import com.management.club.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor //final로 선언된 모든 멤버변수에 대한 생성자를 만들어줌
public class BoardService {

    private final ReplyRepository replyRepository;

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


    //상세정보 조회, 조회수 증가
    @Transactional
    public Board findById(final Long id) {

        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        board.increaseHits();
        return board;
    }

    @Transactional
    public void 댓글쓰기(UserInfo userInfo, Long board_id, Reply requestReply){
        Board board = boardRepository.findById(board_id).orElseThrow(()->{
            return new IllegalArgumentException("댓글쓰기 실패 : 게시글 id를 찾을 수 없습니다.");
        });
        //오브젝트를 넣어주면 알아서 조인되어 코드갑이 들어감
        requestReply.setUserInfo(userInfo);
        requestReply.setBoard(board);

        replyRepository.save(requestReply);
    }

    @Transactional
    public void 댓글삭제(Long replyId){
        replyRepository.deleteById(replyId);
    }


}
