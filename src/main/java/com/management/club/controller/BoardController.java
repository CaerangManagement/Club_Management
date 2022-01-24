package com.management.club.controller;

import com.management.club.dto.BoardRequestDto;
import com.management.club.dto.BoardResponseDto;
import com.management.club.model.Board;
import com.management.club.repository.BoardRepository;
import com.management.club.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class BoardController {


    private final BoardRepository boardRepository;


    private final BoardService boardService;

    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/board/list")
    public String board_list(Model model , @PageableDefault(size = 4 , direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam(value ="searchType", required = false, defaultValue = "1") String searchType){

        //전체 게시글 조회
        if(Integer.parseInt(searchType)==1){
            Page<Board> boards = boardRepository.findAll(pageable);
            int startPage = 1;
            int endPage = boards.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("boards", boards);
            return "/board/board_list";
        }

        //제목으로 조회
        else if(Integer.parseInt(searchType)==2){
            Page<Board> boards = boardRepository.findByTitleContaining(keyword ,pageable);
            int startPage = 1;
            int endPage = boards.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("boards", boards);
            return "/board/board_list";
        }

        //작성자로 조회
        else{
            Page<Board> boards = boardRepository.findByWriterContaining(keyword, pageable);
            int startPage = 1;
            int endPage = boards.getTotalPages();
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("boards", boards);
            return "/board/board_list";
        }

    }


    @GetMapping("/board/add")
    public String board_add(){
        return "/board/board_add";
    }

    
    //게시글 생성
    @PostMapping("/api/boards")
    String save(@ModelAttribute BoardRequestDto params) {
        boardService.save(params);
        return "redirect:/board/list";
    }

    /**
     * 게시글 수정
     */
    @PatchMapping("api/boards/{id}")
    String save(@PathVariable final Long id, @RequestBody final BoardRequestDto params) {
        boardService.update(id, params);
        return "redirect:/board/list";
    }

}
