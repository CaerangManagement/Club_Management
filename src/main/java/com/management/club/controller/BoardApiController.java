package com.management.club.controller;

import com.management.club.dto.BoardRequestDto;
import com.management.club.repository.BoardRepository;
import com.management.club.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}
