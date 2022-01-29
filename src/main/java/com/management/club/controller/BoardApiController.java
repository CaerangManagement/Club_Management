package com.management.club.controller;

import com.management.club.dto.BoardRequestDto;
import com.management.club.model.Reply;
import com.management.club.model.UserInfo;
import com.management.club.repository.BoardRepository;
import com.management.club.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardApiController {

    private final BoardRepository boardRepository;


    private final BoardService boardService;

    /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡapiㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

    //게시글 생성
    @RequestMapping(value="/board/add", method=RequestMethod.POST)
    ResponseEntity<?> save(@RequestBody final BoardRequestDto params) throws IOException {
        Long board_id = boardService.save(params);
        return new ResponseEntity<>(board_id, HttpStatus.CREATED);
    }

    //게시글 수정
    @RequestMapping(value="/board/update/{board_id}", method=RequestMethod.PUT)
    ResponseEntity<?> update(@PathVariable("board_id") final Long id, @RequestBody final BoardRequestDto params) {
        Long board_id = boardService.update(id, params);
        return new ResponseEntity<>(board_id, HttpStatus.OK);
    }

    //게시글 삭제
    @RequestMapping(value="/board/delete/{board_id}", method=RequestMethod.DELETE)
    ResponseEntity<?> delete(@PathVariable("board_id") final Long id) {
        boardRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //댓글 생성
    @RequestMapping(value="/board/{boardId}/reply", method=RequestMethod.POST)
    ResponseEntity<?> saveReply(@PathVariable Long boardId, @RequestBody final Reply reply, @AuthenticationPrincipal UserInfo userInfo
    ) throws IOException {

        boardService.댓글쓰기(userInfo, boardId, reply);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //댓글 삭제
    @RequestMapping(value="/deleteComment/{id}", method=RequestMethod.DELETE)
    ResponseEntity<?> deleteReply(@PathVariable("id") Long id
    ) throws IOException {
        boardService.댓글삭제(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
