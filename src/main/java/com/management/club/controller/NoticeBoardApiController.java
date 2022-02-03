package com.management.club.controller;

import com.management.club.dto.NoticeBoardRequestDto;
import com.management.club.repository.NoticeBoardRepository;
import com.management.club.service.NoticeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NoticeBoardApiController {

    private final NoticeBoardRepository noticeBoardRepository;


    private final NoticeBoardService noticeBoardService;

    /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡapiㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

    //게시글 생성
    @RequestMapping(value="/notice/board/add", method=RequestMethod.POST)
    ResponseEntity<?> save(@RequestBody final NoticeBoardRequestDto params) throws IOException {
        Long Notice_board_id = noticeBoardService.save(params);
        return new ResponseEntity<>(Notice_board_id, HttpStatus.CREATED);
    }

    //게시글 수정
    @RequestMapping(value="/notice/board/update/{board_id}", method=RequestMethod.PUT)
    ResponseEntity<?> update(@PathVariable("board_id") final Long id, @RequestBody final NoticeBoardRequestDto params) {
        Long Notice_board_id = noticeBoardService.update(id, params);
        return new ResponseEntity<>(Notice_board_id, HttpStatus.OK);
    }

    //게시글 삭제
    @RequestMapping(value="/notice/board/delete/{board_id}", method=RequestMethod.DELETE)
    ResponseEntity<?> delete(@PathVariable("board_id") final Long id) {
        noticeBoardRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
