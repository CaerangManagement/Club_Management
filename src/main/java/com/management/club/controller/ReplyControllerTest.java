package com.management.club.controller;

import com.management.club.model.Board;
import com.management.club.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyControllerTest {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/test/board/{id}")
    public Board getBoard(@PathVariable Long id){
        return boardRepository.findById(id).get();
    }
}
